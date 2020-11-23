package br.edu.up.DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Produto;


public class ProdutoDAO implements DAO<Produto> 
{

	@Override
	public Produto salvar(Produto produto) 
	{
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			String sql = "INSERT INTO produtos (fornecedor_produto, id_produto, nome_produto, descricao_produto, preco_produto) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement executor = conexao.prepareStatement(sql);
			executor.setString(1, produto.getFornecedorProduto());
			executor.setString(2, produto.getIdProduto());
			executor.setString(3, produto.getNomeProduto());
			executor.setString(4, produto.getDescricaoProduto());
			executor.setDouble(5, produto.getPrecoProduto());
			
			
			int retorno = executor.executeUpdate();
			
			System.out.println("Retorno: " + retorno);
			
			executor.close();
			conexao.close();
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
			
			System.out.println("Erro ao salvar produto!");
		}
		
		return produto;
	}

	@Override
	public Produto atualizar(Produto produto) 
	{
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			String sql = "UPDATE produtos SET fornecedor_produto = ?, id_produto = ?, nome_produto =?, descricao_produto = ?, preco_produto =? WHERE id_produto = ?";
			PreparedStatement executor = conexao.prepareStatement(sql);
			executor.setString(1, produto.getFornecedorProduto());	
			executor.setString(2, produto.getIdProduto());
			executor.setString(3, produto.getNomeProduto());
			executor.setString(4, produto.getDescricaoProduto());
			executor.setDouble(5, produto.getPrecoProduto());
					
			
			int retorno = executor.executeUpdate();
			
			System.out.println("Retorno: " + retorno);
			
			executor.close();
			conexao.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao atualizar o produto!");
			//e.printStackTrace();
		}
		return produto;
	}

	@Override
	public Produto buscarPorId(String id) 
	{
		return null;
	}

	@Override
	public List<Produto> listar() 
	{
		List<Produto> listaProdutos = new ArrayList();
		
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			Statement executor = conexao.createStatement();
			String sql = "SELECT * FROM produtos";
			ResultSet resultado = executor.executeQuery(sql);
			
			while(resultado.next())
			{
				String fornecedorProduto = resultado.getString("fornecedor_produto");
				String idProduto = resultado.getString("id_produto");
				String nomeProduto = resultado.getString("nome_produto");
				String descricaoProduto = resultado.getString("descricao_produto");
				Double precoProduto = resultado.getDouble("preco_produto");
								
				Produto produto = new Produto(fornecedorProduto, idProduto, nomeProduto, descricaoProduto, precoProduto);
				listaProdutos.add(produto);
			}
			
			executor.close();
			conexao.close();
			
		} 		
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar produtos!");	
		}
		
		return listaProdutos;
	}

	@Override
	public void apagar(String id) 
	{
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			String sql = "DELETE FROM produtos WHERE id_produto = ?";
			PreparedStatement executor = conexao.prepareStatement(sql);
			executor.setString(1, id);
			
			int retorno = executor.executeUpdate();

			System.out.println("Retorno: " + retorno);

			executor.close();
			conexao.close();
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao apagar produto!");
			e.printStackTrace();
		}
		
	}

	public void salvar(String idFornecedor, String idProdutoIncluir, String nomeProdutoIncluir,
			String descricaoProdutoIncluir, Double precoProdutoIncluir) 
	{
		// TODO Auto-generated method stub
		
	}	
}
