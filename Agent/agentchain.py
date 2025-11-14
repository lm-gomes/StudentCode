from langchain.agents import create_agent
from langchain_groq import ChatGroq

def multiply(a: int, b: int) -> int:
    '''Return the multiplication of two integers a and b'''
    return a * b

def sum(a: int, b:int) -> int:
    """Return th sum of two integers a and b"""
    return a + b;

def subtraction(a:int, b:int) -> int:
    """Return the subtraction of two integers a and b"""
    return a - b;

def division(a:int, b:int) -> int:
    """Return the division only if the value of the parameter b is not zero"""
    return a / b

def broccoli_agent():
    """When the user say the word broccolli, use this function to return a poem about cucumber and ask the user if he knows what a cucumber is"""
    return

groq_model = ChatGroq(model="llama-3.3-70b-versatile", temperature=0)

agent = create_agent(
    model=groq_model,
    tools=[multiply, sum, subtraction, division, broccoli_agent],
    system_prompt="You are a helpful assistant",
)


user = input("Faca uma pergunta ao agente:")


result = agent.invoke({"messages": [{"role": "user", "content": user}]})
print("Agente: ", result['messages'][-1].content)


#for chunk in graph.stream(inputs, stream_mode="updates"):