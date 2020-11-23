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
import br.edu.up.model.Venda;


public class VendaDAO implements DAO<Venda> 
{

	@Override
	public Venda salvar(Venda venda) 
	{
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			String sql = "INSERT INTO vendas (id_venda, id_cliente, id_produto, data_compra) VALUES (?, ?, ?, ?)";
			PreparedStatement executor = conexao.prepareStatement(sql);
			executor.setString(1, venda.getIdVenda());
			executor.setString(2, venda.getIdCliente());
			executor.setString(3, venda.getIdProduto());
			executor.setString(4, venda.getDataCompra());
			
			
			int retorno = executor.executeUpdate();
			
			System.out.println("Retorno: " + retorno);
			
			executor.close();
			conexao.close();
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
			
			System.out.println("Erro ao salvar venda!");
		}
		
		return venda;
	}

	@Override
	public Venda atualizar(Venda venda)
	{
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			String sql = "UPDATE vendas SET id_venda = ?, id_cliente = ?, id_produto = ?, data_compra = ? WHERE id_venda = ?";
			PreparedStatement executor = conexao.prepareStatement(sql);
			executor.setString(1, venda.getIdVenda());
			executor.setString(2, venda.getIdCliente());
			executor.setString(3, venda.getIdProduto());
			executor.setString(4, venda.getDataCompra());
			executor.executeUpdate();
			
			executor.close();
			conexao.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao atualizar o venda!");
		}
		return venda;
	}

	@Override
	public Venda buscarPorId(String id) 
	{
		return null;
	}

	@Override
	public List<Venda> listar() 
	{
		List<Venda> listaVendas = new ArrayList();
		
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			Statement executor = conexao.createStatement();
			String sql = "SELECT * FROM vendas";
			ResultSet resultado = executor.executeQuery(sql);
			
			while(resultado.next())
			{
				String idVenda = resultado.getString("id_venda");
				String idCliente = resultado.getString("id_cliente");
				String idProduto = resultado.getString("id_produto");
				String dataCompra = resultado.getString("data_compra");
								
				Venda venda = new Venda(idVenda, idCliente, idProduto, dataCompra);
				listaVendas.add(venda);
				
			}
			
			executor.close();
			conexao.close();
			
		} 		
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar vendas!");	
		}
		
		return listaVendas;
	}

	@Override
	public void apagar(String idVendaExcluir) 
	{
		try 
		{
			Connection conexao = Conexao.getConnection();
			
			String sql = "DELETE FROM vendas WHERE id_venda = ?";
			PreparedStatement executor = conexao.prepareStatement(sql);
			executor.setString(1, idVendaExcluir);			
			executor.executeUpdate();

			executor.close();
			conexao.close();
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao apagar venda!");
			e.printStackTrace();
		}				
	}
}
