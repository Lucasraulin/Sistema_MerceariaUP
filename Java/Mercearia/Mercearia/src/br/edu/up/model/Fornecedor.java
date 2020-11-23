package br.edu.up.model;

public class Fornecedor 
{
	private String cnpj;
	private String nomeFornecedor;
	private String emailFornecedor;
	private String enderecoFornecedor;
	private String telefoneFornecedor;
	
	
	public Fornecedor() 
	{
	
	}
		
	public Fornecedor(String cnpj, String nomeFornecedor, String emailFornecedor, String enderecoFornecedor, String telefoneFornecedor) 
	{
		this.cnpj = cnpj;
		this.nomeFornecedor = nomeFornecedor;
		this.emailFornecedor = emailFornecedor;
		this.enderecoFornecedor = enderecoFornecedor;
		this.telefoneFornecedor = telefoneFornecedor;
	}
	
	public Fornecedor(String nomeFornecedor, String emailFornecedor, String enderecoFornecedor, String telefoneFornecedor) 
	{
		this.nomeFornecedor = nomeFornecedor;
		this.emailFornecedor = emailFornecedor;
		this.enderecoFornecedor = enderecoFornecedor;
		this.telefoneFornecedor = telefoneFornecedor;
	}
		
	public String getCnpj() 
	{
		return cnpj;
	}
	
	public void setCnpj(String cnpj) 
	{
		this.cnpj = cnpj;
	}
	
	public String getNomeFornecedor() 
	{
		return nomeFornecedor;
	}
	
	public void setNomeFornecedor(String nomeFornecedor) 
	{
		this.nomeFornecedor = nomeFornecedor;
	}
	
	public String getEmailFornecedor() 
	{
		return emailFornecedor;
	}
	
	public void setEmailFornecedor(String emailFornecedor)
	{
		this.emailFornecedor = emailFornecedor;
	}
	
	public String getEnderecoFornecedor() 
	{
		return enderecoFornecedor;
	}
	
	public void setEnderecoFornecedor(String enderecoFornecedor)
	{
		this.enderecoFornecedor = enderecoFornecedor;
	}
	
	public String getTelefoneFornecedor() 
	{
		return telefoneFornecedor;
	}
	
	public void setTelefoneFornecedor(String telefoneFornecedor) 
	{
		this.telefoneFornecedor = telefoneFornecedor;
	}
	
	@Override
	public String toString() 
	{		
		return "CNPJ: " + cnpj + " - " + "Nome fornecedor: " + nomeFornecedor;
	}
	
}
