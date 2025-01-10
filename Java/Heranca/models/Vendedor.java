package models;

public class Vendedor extends Funcionario{
	protected double comissao;
	
	public Vendedor(String nome, int idade, double salarioBase, double comissao){
		super(nome, idade, salario);
		this.comissao = comissao;
	}

	public double getComissao(){
		return comissao;
	}

	@Override
	public double calcularSalario(){
		salarioBase += comissao;
		return salarioBase;
	}

	@Override
	public void exibirDetalhes(){
		super.exibirDetalhes();
		System.out.println("Comissao: " + comissao);
	}

}
