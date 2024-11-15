class Pessoa{
	public String nome;
	public int idade;
	public float altura;
	public float peso;
	
	public String toString(){
		return ("Nome: " + nome + ", Idade: " + idade + ", Altura: " + altura + ", Peso: " + peso);
	}
	
}

public class IMC{
	public static void main(String[] args){
		Pessoa pessoa = new Pessoa();
		pessoa.nome = "Filipe";
		pessoa.idade = 26;
		pessoa.altura = 1.70f;
		pessoa.peso = 75f;
		System.out.println(pessoa.toString());
	
	}
}
