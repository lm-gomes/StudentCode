package models;

public class Gerente extends Funcionario{
	
	public Gerente(String nome, int idade, double salarioBase, String departamento){
		super(nome, idade, salario);
		this.departamento = departamento;
	}

	protected String departamento;
	
	public String getDepartamento(){
		return departamento;
	}
	
	public void setDepartamento(String departamento){
		this.departamento = departamento;
	}


	@Override
	public double calcularSalario(){		
		return salarioBase * 1.20;
	}

	@Override
	public void exibirDetalhes(){
		super.exibirDetalhes();
		System.out.println("Departamento: " + departamento);
	}
	
}