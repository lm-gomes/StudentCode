class Livro{
	String titulo;
	String autor;
	String editora;
	int anoPublicacao;
	
	public Livro(String titulo, String autor, String editora, int anoPublicacao){
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.anoPublicacao = anoPublicacao;
	}

	void mudarEditora(String novonome){
		editora = novonome;	
	}	
	
	int calcularIdade(int anoAtual){
		return anoAtual - anoPublicacao;
	}
	
	void imprimeInformacoes(){
		System.out.printf("Titulo: %s\nAutor: %s\nEditora: %s\nAno de Publicacao: %d", titulo, autor, editora, anoPublicacao);
	}

}

public class PooClass{
	public static void main(String args[]){
		Livro livro1 = new Livro("A Metamorfose", "Franz Kafka", "Companhia das Letras", 1915);
		livro1.imprimeInformacoes();
		System.out.println("");
		livro1.mudarEditora("Thomas Nelson");
		livro1.anoPublicacao = 2000;
		int idadeLivro = livro1.calcularIdade(2024);
		System.out.print(idadeLivro);
		livro1.imprimeInformacoes();
		System.out.printf("\nIdade do livro: %s", idadeLivro);
			
	}
}


	