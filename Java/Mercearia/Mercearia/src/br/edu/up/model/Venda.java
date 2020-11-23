package br.edu.up.model;

public class Venda 
{
	private String idVenda;
	private String idCliente;
	private String idProduto;
	private String dataCompra;
	
	public Venda() 	
	{
	
	}
			
	public Venda(String idVenda, String idCliente, String idProduto, String dataCompra) 
	{
		super();
		this.idVenda = idVenda;
		this.idCliente = idCliente;
		this.idProduto = idProduto;
		this.dataCompra = dataCompra;
	}

	public Venda(String idCliente, String idProduto, String dataCompra) 
	{
		super();		
		this.idCliente = idCliente;
		this.idProduto = idProduto;
		this.dataCompra = dataCompra;
	}
		
	
	public String getIdVenda() 
	{
		return idVenda;
	}
	
	public void setIdVenda(String idVenda) 
	{
		this.idVenda = idVenda;
	}
	
	public String getIdCliente() 
	{
		return idCliente;
	}
	
	public void setIdCliente(String idCliente)
	{
		this.idCliente = idCliente;
	}
	
	public String getIdProduto()
	{
		return idProduto;
	}
	
	public void setIdProduto(String idProduto)
	{
		this.idProduto = idProduto;
	}
	
	public String getDataCompra() 
	{
		return dataCompra;
	}
	
	public void setDataCompra(String dataCompra)
	{
		this.dataCompra = dataCompra;
	}	
	
	@Override
	public String toString() 
	{		
		return "ID Venda: " + idVenda + " - " + "ID Cliente: " + idCliente + " - " + "ID Produto: " + idProduto + " - " + "Data de compra: " + dataCompra;
	}


}
