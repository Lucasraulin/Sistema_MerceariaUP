package br.edu.up.model;

public class Produto 
{
	private String idProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private double precoProduto;
	private String fornecedorProduto;
	
	public Produto() 
	{
	
	}

	public Produto(String fornecedorProduto, String idProduto, String nomeProduto, String descricaoProduto, Double precoProduto) 	
	{
		super();
		this.fornecedorProduto = fornecedorProduto;
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.precoProduto = precoProduto;
	}
	
	public Produto(String fornecedorProduto, String nomeProduto, String descricaoProduto, Double precoProduto) 	
	{
		super();
		this.fornecedorProduto = fornecedorProduto;	
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.precoProduto = precoProduto;
	}
	
	public String getIdProduto() 
	{
		return idProduto;
	}
	
	public void setIdProduto(String idProduto) 
	{
		this.idProduto = idProduto;
	}
	
	public String getNomeProduto() 
	{
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) 
	{
		this.nomeProduto = nomeProduto;
	}
	
	public String getDescricaoProduto() 
	{
		return descricaoProduto;
	}
	
	public void setDescricaoProduto(String descricaoProduto)
	{
		this.descricaoProduto = descricaoProduto;
	}
	
	public double getPrecoProduto() 
	{
		return precoProduto;
	}
	
	public void setPrecoProduto(double precoProduto) 
	{
		this.precoProduto = precoProduto;
	}
	
	public String getFornecedorProduto() 
	{
		return fornecedorProduto;
	}
	
	public void setFornecedorProduto(String fornecedorProduto)
	{
		this.fornecedorProduto = fornecedorProduto;
	}
	
	@Override
	public String toString() 
	{		
		return "ID Produto: " + idProduto + " - " + "Nome produto: " + nomeProduto + " - " + "Preço: " + precoProduto;
	}
	
}
