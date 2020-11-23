package br.edu.up.model;

import java.awt.List;

public class Cliente 
{
	private String idCliente;
	private String cpfCliente;
	private String nomeCliente;
	private String emailCliente;
	

	public Cliente() 
	{
	
	}
			
	public Cliente(String idCliente, String cpfCliente, String nomeCliente, String emailCliente) 	
	{
		super();
		this.idCliente = idCliente;
		this.cpfCliente = cpfCliente;
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
	}
	
	public Cliente(String cpfCliente, String nomeCliente, String emailCliente) 	
	{
		super();		
		this.cpfCliente = cpfCliente;
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
	}
	
	public String getIdCliente() 
	{
		return idCliente;
	}
	
	public void setIdCliente(String idCliente) 
	{
		this.idCliente = idCliente;
	}
	
	public String getCpfCliente() 
	{
		return cpfCliente;
	}
	
	public void setCpfCliente(String cpfCliente) 
	{
		this.cpfCliente = cpfCliente;
	}
	
	public String getNomeCliente() 
	{
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) 
	{
		this.nomeCliente = nomeCliente;
	}
	
	public String getEmailCliente() 
	{
		return emailCliente;
	}
	
	public void setEmailCliente(String emailCliente) 
	{
		this.emailCliente = emailCliente;
	}
	
	@Override
	public String toString() 
	{		
		return "ID Cliente: " + idCliente + " - " + "Nome cliente: " + nomeCliente;		
	}
}
	
	
	