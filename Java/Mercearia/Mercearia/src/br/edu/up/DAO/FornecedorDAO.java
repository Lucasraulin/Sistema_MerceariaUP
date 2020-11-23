package br.edu.up.DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Fornecedor;


public class FornecedorDAO implements DAO<Fornecedor> 
{

	@Override
	public Fornecedor salvar(Fornecedor fornecedor) 
	{
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			String sql = "INSERT INTO fornecedor (cnpj, nome_fornecedor, email_fornecedor, endereco_fornecedor, telefone_fornecedor) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement executor = conexao.prepareStatement(sql);
			executor.setString(1, fornecedor.getCnpj());
			executor.setString(2, fornecedor.getNomeFornecedor());
			executor.setString(3, fornecedor.getEmailFornecedor());
			executor.setString(4, fornecedor.getEnderecoFornecedor());
			executor.setString(5, fornecedor.getTelefoneFornecedor());
			
			
			int retorno = executor.executeUpdate();
			
			System.out.println("Retorno: " + retorno);
			
			executor.close();
			conexao.close();
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
			
			System.out.println("Erro ao salvar fornecedor!");
		}
		
		return fornecedor;
	}

	@Override
	public Fornecedor atualizar(Fornecedor fornecedor) 
	{
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			String sql = "UPDATE fornecedor SET cnpj = ?, nome_fornecedor = ?, email_fornecedor = ?, endereco_fornecedor = ?, telefone_fornecedor = ? WHERE cnpj = ?";
			PreparedStatement executor = conexao.prepareStatement(sql);
			executor.setString(1, fornecedor.getCnpj());
			executor.setString(2, fornecedor.getNomeFornecedor());
			executor.setString(3, fornecedor.getEmailFornecedor());
			executor.setString(4, fornecedor.getEnderecoFornecedor());
			executor.setString(5, fornecedor.getTelefoneFornecedor());		
			
			int retorno = executor.executeUpdate();
			
			System.out.println("Retorno: " + retorno);
			
			executor.close();
			conexao.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao atualizar o fornecedor!");
		}
		
		
		return fornecedor;
	}

	@Override
	public Fornecedor buscarPorId(String cnpj) 
	{
		return null;
	}

	@Override
	public List<Fornecedor> listar() 
	{
		List<Fornecedor> listaFornecedores = new ArrayList();
		
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			Statement executor = conexao.createStatement();
			String sql = "SELECT * FROM fornecedor";
			ResultSet resultado = executor.executeQuery(sql);
			
			while(resultado.next())
			{
				String cnpj = resultado.getString("cnpj");
				String nomeFornecedor = resultado.getString("nome_fornecedor");				
				String emailFornecedor = resultado.getString("email_fornecedor");
				String enderecoFornecedor = resultado.getString("endereco_fornecedor");
				String telefoneFornecedor = resultado.getString("telefone_fornecedor");
				
				Fornecedor fornecedor = new Fornecedor(cnpj, nomeFornecedor, emailFornecedor, enderecoFornecedor, telefoneFornecedor);
				listaFornecedores.add(fornecedor);
			}
			
			executor.close();
			conexao.close();
			
		} 		
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar itens do cardápio!");				
		}
		

		return listaFornecedores;
	}

	@Override
	public void apagar(String cnpj) 
	{
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			String sql = "DELETE FROM fornecedor WHERE cnpj = ?";
			PreparedStatement executor = conexao.prepareStatement(sql);
			executor.setString(1, cnpj);
			
			int retorno = executor.executeUpdate();

			System.out.println("Retorno: " + retorno);

			executor.close();
			conexao.close();
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao apagar fornecedor!");
			e.printStackTrace();
		}
	}
}
