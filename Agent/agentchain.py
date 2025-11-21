from typing import Literal, TypedDict
from langgraph.graph import START, MessagesState, StateGraph, END
from langchain_groq import ChatGroq

model = ChatGroq(model="llama-3.3-70b-versatile", temperature=0)


class Classification(TypedDict):
    intent: Literal["criar_arquivo", "nao_arquivo"]



class MyState(TypedDict):
    classification: Classification
    user_input: str
    ai_answer: str
    pass

structured_model = model.with_structured_output(Classification)

def inputNode(state: MyState) -> MyState:
    user = input("Digite: ")

    return {"ai_answer": model.invoke(user), "user_input": user}

def router(state: MyState) -> MyState:
    classification_prompt = f"Mensagem do usuário: {state["user_input"]}\nCaso o usuário tenha digitado que deseja criar um arquivo, sua resposta deve ser 'criar_arquivo', e caso não queira, deve ser 'nao_arquivo' "
    classification = structured_model.invoke(classification_prompt)
    print(classification["intent"])
    return {"classification": classification}

def criar_arquivo(state: MyState):
    file_name = input("Digite o nome do arquivo: ")
    classification_prompt = f"Prompt do usuário: {file_name}\nSe o usuário digitar APENAS o nome de arquivo e sua extensão, sua resposta deve ser 'criar_arquivo', e caso não seja, deve ser 'nao_arquivo' "
    classification = structured_model.invoke(classification_prompt)
    if(classification["intent"] == "criar_arquivo"):
        file = open(f"{file_name}", mode="w")
        print(f"Arquivo {file_name} criado!")
        text = input("Digite o texto que deseja inserir no arquivo: ")
        file.write(text)
    else:
        print("Especifique o nome e formato do arquivo!\n")
    
    return {"classification": classification}


graph = StateGraph(MyState)
graph.add_node("input", inputNode)
graph.add_node("router", router)
graph.add_node("criar_arquivo", criar_arquivo)

graph.add_edge(START, "input")
graph.add_edge("input", "router")
graph.add_conditional_edges("router", lambda state: state["classification"]["intent"], {"criar_arquivo":"criar_arquivo", "nao_arquivo": END})
graph.add_conditional_edges("criar_arquivo", lambda state: state["classification"]["intent"], {"criar_arquivo":END, "nao_arquivo":"criar_arquivo"})


graph = graph.compile()

graph.invoke({})
