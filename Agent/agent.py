from langchain.tools import tool
from langchain.chat_models import init_chat_model
from langchain_groq import ChatGroq

from langchain.messages import AnyMessage, SystemMessage, ToolMessage
from typing_extensions import TypedDict, Annotated
import operator

from typing import Literal
from langgraph.graph import StateGraph, START, END


#model = init_chat_model(model_provider="groq", temperature=0)

model = ChatGroq(model="llama-3.3-70b-versatile", temperature=0)

@tool
def multiply(a:int, b:int) -> int:
    """Multiply 'a' and 'b'.

    Args:
        a: First int
        b: Second int
    
    """

    return a * b

tools = [multiply]
tools_by_name = {tool.name: tool for tool in tools}
model_with_tools = model.bind_tools(tools_by_name)

class MessageState(TypedDict):
    messages: Annotated[list[AnyMessage], operator.add]
    llm_calls: int

def llm_call(state: dict):
    """LLM decides whether to call a tool or not"""

    return {
        "messages": [
            model_with_tools.invoke([
                SystemMessage(content="You're a helpful assistant that uses arithmetic when needed to help answering")
            ] + state["messages"])
        ],
        "llm_calls": state.get('llm_calls', 0) + 1
    }
    
def tool_node(state: dict):
    """Performs the tool call"""

    result = []
    for tool_call in state["messages"][-1].tool_calls:
        tool = tools_by_name[tool_call["name"]]
        observation = tool.invoke(tool_call["args"])
        result.append(ToolMessage(content=observation, tool_call_id=tool_call["id"]))
    return {"messages": result}

def should_continue(state: MessageState) -> Literal["tool_node", END]:
    """Decide if we should continue the loop or stop based upon whether the LLM made a tool call"""

    messages = state["messages"]
    last_message = messages[-1]

    if last_message.tool_calls:
        return "tool_node"
    
    return END

# Build workflow
agent_builder = StateGraph(MessageState)

# Add nodes
agent_builder.add_node("llm_call", llm_call)
agent_builder.add_node("tool_node", tool_node)

# Add edges to connect nodes
agent_builder.add_edge(START, "llm_call")
agent_builder.add_conditional_edges(
    "llm_call",
    should_continue,
    ["tool_node", END]
)
agent_builder.add_edge("tool_node", "llm_call")

# Compile the agent
agent = agent_builder.compile()


# Invoke
from langchain.messages import HumanMessage
messages = [HumanMessage(content="Add 3 and 4.")]
messages = agent.invoke({"messages": messages})
for m in messages["messages"]:
    m.pretty_print()