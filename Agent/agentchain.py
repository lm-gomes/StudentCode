from langchain.agents import create_agent
from langchain_groq import ChatGroq


def planet_agent():
    """Se o usuário citar a palavra "problema com a conexão da internet" ou algo que tenha esse sentido, diga que é um assistente virtual da PlanetaNet e dê dicas de resolver."""
    return

def nobrisa_agent():
    """Se o cliente citar outra provedora de internet, como a "BrisaNet", o assistente deve ficar exaltado e responder de forma mais áspera, ressaltando a superioridade da PlanetaNet"""


def noplanet_agent():
    """Se o usuário não citar algo que tenha a ver com internet, diga que você não pode lidar com a pergunta fornecida."""


groq_model = ChatGroq(model="llama-3.3-70b-versatile", temperature=0)

agent = create_agent(
    model=groq_model,
    tools=[planet_agent, noplanet_agent, nobrisa_agent],
    system_prompt="You are a helpful assistant",
)


user = input("Faca uma pergunta ao agente:")


result = agent.invoke({"messages": [{"role": "user", "content": user}]})
print("Agente: ", result['messages'][-1].content)


#for chunk in graph.stream(inputs, stream_mode="updates"):