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

	void mudarInfo(String novonome, int op){
		switch(op){
			case 1:{
				titulo = novonome;
				break;
			}
			case 2:{
				autor = novonome;
				break;	
			}
			case 3:{
				editora = novonome;
				break;
			}
			
			case 4:{
				anoPublicacao = Integer.parseInt(novonome);
				break;
			}
			default:{
				System.out.println("Opcao invalida!");
			}
			
				
		}
		
		
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
		livro1.mudarInfo("1984", 1);
		livro1.mudarInfo("George Orwell", 2);
		livro1.mudarInfo("1949", 4);
		
		int idadeLivro = livro1.calcularIdade(2024);
		
		livro1.imprimeInformacoes();
		System.out.printf("\nIdade do livro: %s", idadeLivro);
			
	}
}


	