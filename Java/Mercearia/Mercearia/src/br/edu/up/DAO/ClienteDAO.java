package br.edu.up.DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import br.edu.up.model.Cliente;



public class ClienteDAO implements DAO<Cliente> 
{

	@Override
	public Cliente salvar(Cliente cliente) 
	{
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			String sql = "INSERT INTO clientes (id_cliente, cpf_cliente, nome_cliente, email_cliente) VALUES (?, ?, ?, ?)";
			PreparedStatement executor = conexao.prepareStatement(sql);
			executor.setString(1, cliente.getIdCliente());
			executor.setString(2, cliente.getCpfCliente());
			executor.setString(3, cliente.getNomeCliente());
			executor.setString(4, cliente.getEmailCliente());			
			
			int retorno = executor.executeUpdate();
			
			System.out.println("Retorno: " + retorno);
			
			executor.close();
			conexao.close();
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
			
			System.out.println("Erro ao salvar cliente!");
		}
		return cliente;
	}

	@Override
	public Cliente atualizar(Cliente cliente) 
	{
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			String sql = "UPDATE produtos SET id_cliente = ?, cpf_cliente = ?, nome_cliente = ?, email_cliente = ? WHERE id_cliente = ?";
			PreparedStatement executor = conexao.prepareStatement(sql);			
			executor.setString(1, cliente.getIdCliente());
			executor.setString(2, cliente.getCpfCliente());
			executor.setString(3, cliente.getNomeCliente());
			executor.setString(4, cliente.getEmailCliente());		
			
			int retorno = executor.executeUpdate();
			
			System.out.println("Retorno: " + retorno);
			
			executor.close();
			conexao.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao atualizar o cliente!");
			//e.printStackTrace();
		}

		return cliente;
	}

	@Override
	public Cliente buscarPorId(String id) 
	{
		return null;
	}

	@Override
	public List<Cliente> listar() 
	{
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			Statement executor = conexao.createStatement();
			String sql = "SELECT * FROM clientes";
			ResultSet resultado = executor.executeQuery(sql);
			
			while(resultado.next())
			{
				String id = resultado.getString("id_cliente");
				String cpf = resultado.getString("cpf_cliente");
				String nome = resultado.getString("nome_cliente");
				String descricao = resultado.getString("email_cliente");				
								
				Cliente cliente = new Cliente(id, cpf, nome, descricao);				
				listaClientes.add(cliente);
			}
			
			executor.close();
			conexao.close();
			
		} 		
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar produtos!");	
		}
		return listaClientes;
	}

	@Override
	public void apagar(String id) 
	{
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			String sql = "DELETE FROM clientes WHERE id_cliente = ?";
			PreparedStatement executor = conexao.prepareStatement(sql);
			executor.setString(1, id);
			
			int retorno = executor.executeUpdate();

			System.out.println("Retorno: " + retorno);

			executor.close();
			conexao.close();
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao apagar cliente!");
			e.printStackTrace();
		}	
		
	}	
	
	
}
