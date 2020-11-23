package br.edu.up.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import br.edu.up.DAO.ClienteDAO;
import br.edu.up.DAO.FornecedorDAO;
import br.edu.up.DAO.ProdutoDAO;
import br.edu.up.DAO.VendaDAO;
import br.edu.up.model.Cliente;
import br.edu.up.model.Fornecedor;
import br.edu.up.model.Produto;
import br.edu.up.model.Venda;


public class Menu
{
	private int opcaoEscolhida;	
	
	ClienteDAO clienteDAO = new ClienteDAO();        
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    ProdutoDAO produtoDAO = new ProdutoDAO();
    VendaDAO vendaDAO = new VendaDAO();
	
	Scanner leitorMenu = new Scanner(System.in);
	
	
	public void imprimirMenuPrincipal() throws IOException
	{
		System.out.println("\nPor gentileza, selecione a opção desejada:");       
        System.out.println("[1] Cadastrar ou remover produtos");
        System.out.println("[2] Cadastrar nova venda"); 
        System.out.println("[3] Remover venda");         
        System.out.println("[0] Sair\n");        
       
        opcaoMenuEscolhida(opcaoEscolhida);		
	}    
	
	
	public void opcaoMenuEscolhida (int opcaoEscolhida) throws IOException
	{
		opcaoEscolhida = leitorMenu.nextInt();
		leitorMenu.nextLine();
		
		switch(opcaoEscolhida) 
		{
	        case 0:
	            System.out.println("\nFinalizando o sistema gerencial.");          
	        break;
	        
	        case 1:
	        	
	        	List<Produto> listaProdutos = produtoDAO.listar();
	    		
	    		for (Produto produto : listaProdutos)
	    		{
	    			System.out.println(produto);
	    		}	
	        	
	    		System.out.println("--------------------------------------");
	            System.out.println("Digite a opção desejada:\n");
	            System.out.println("[1] Cadastrar produto");	         
	            System.out.println("[2] Remover produto");           
	            System.out.println("[0] Voltar");
	            
	            opcaoMenuSecundarioEscolhida();	            
			break;
			
	        case 2:
	        	
	        	Venda venda = new Venda();	        	
	        	
	            System.out.println("Informe o id do venda:");
	            String idVenda = leitorMenu.nextLine();
	            venda.setIdVenda(idVenda);
	        	
	            System.out.println("----------------CLIENTES---------------");
	        	List<Cliente> listaClientes = clienteDAO.listar();		
	    		
	    		for (Cliente cliente : listaClientes)
	    		{
	    			System.out.println(cliente);	    			
	    		}	
	    		
	    		System.out.println("--------------------------------------");
	            System.out.println("Informe o id do cliente:");	                       
	            String idCliente = leitorMenu.nextLine();
	            venda.setIdCliente(idCliente);
	            
	            System.out.println("----------------PRODUTOS---------------");
	            List<Produto> listaProdutos1 = produtoDAO.listar();
	    		
	    		for (Produto produto : listaProdutos1)
	    		{
	    			System.out.println(produto);
	    		}	
	    		
	    		System.out.println("--------------------------------------");
	            System.out.println("Informe o id do produto:");
	            String idProduto = leitorMenu.nextLine();
	            venda.setIdProduto(idProduto);
	             
	            System.out.println("--------------------------------------");
	            System.out.println("Informe a data da compra:");
	            String dataCompra = leitorMenu.nextLine();
	            venda.setDataCompra(dataCompra);
	            
	            vendaDAO.salvar(venda);              
	           
	            imprimirVendas();
	            imprimirMenuPrincipal();
	        break;
	        
	        case 3:
	            System.out.println("\nInforme o id da venda a ser removido:\n");
	            //leitorMenu.nextLine();
	            String idVendaExcluir = leitorMenu.nextLine();	
	            leitorMenu.nextLine();
	            
	            vendaDAO.apagar(idVendaExcluir);	            
	            System.out.println("Venda removida com sucesso!");
	           
	            	            
	            imprimirVendas();
	            imprimirMenuPrincipal();
	        break;
	        	       
		    default:
		    	System.out.println("\nOpção inválida.\n");
		    break;    
		} 
		while (opcaoEscolhida != 0);
	
		leitorMenu.close();
	}
	
	public void opcaoMenuSecundarioEscolhida() throws IOException 
	{
		int opcaoEscolhidaMenuSecundario = -1;
		opcaoEscolhidaMenuSecundario = leitorMenu.nextInt();
        
        switch(opcaoEscolhidaMenuSecundario) 
        {
	        case 0:
	        	imprimirMenuPrincipal();
	        break;
	        
	        case 1:
	        	List<Fornecedor> listaFornecedores = fornecedorDAO.listar();		
				
	    		for (Fornecedor fornecedor : listaFornecedores)
	    		{
	    			System.out.println(fornecedor);
	    		}	
	    		
	    		Produto produto = new Produto();
	    		
	        	System.out.println("\nInforme o fornecedor do produto:\n");
	            leitorMenu.nextLine();
	            String idFornecedor = leitorMenu.nextLine();
	        	produto.setFornecedorProduto(idFornecedor);	
	        	
	        	System.out.println("\nInforme o id do produto:\n");
	            
	            String idProdutoIncluir = leitorMenu.nextLine();
	            produto.setIdProduto(idProdutoIncluir);
	            leitorMenu.nextLine();
	            
	            System.out.println("\nInforme o nome do produto:\n");
	            String nomeProdutoIncluir = leitorMenu.nextLine();
	            produto.setNomeProduto(nomeProdutoIncluir);
	            leitorMenu.nextLine();
	            
	            System.out.println("\nInforme a descrição do produto:\n");	            
	            String descricaoProdutoIncluir = leitorMenu.nextLine();
	            produto.setDescricaoProduto(descricaoProdutoIncluir);
	            leitorMenu.nextLine();
	            
	            System.out.println("\nInforme o preço do produto:\n");	            
	            Double precoProdutoIncluir = leitorMenu.nextDouble();
	            produto.setPrecoProduto(precoProdutoIncluir);
	            leitorMenu.nextLine();
	            
	            produtoDAO.salvar(produto);
	            
	            System.out.println("Produto cadastrado com sucesso!");
	            
	            imprimirMenuPrincipal();
	        break;       
	       
	        case 2:
	            System.out.println("\nInforme o id do produto a ser removido:\n");
	            leitorMenu.nextLine();
	            String idProdutoExcluir = leitorMenu.nextLine();
	            
	            produtoDAO.apagar(idProdutoExcluir);	            
	            
	            System.out.println("Produto removido com sucesso!");
	            
	            imprimirMenuPrincipal();
	        break;
	        
	        default:
	            System.out.println("----  Opção inválida.  ----");	
	        break;
        }      
    }
	
	public void imprimirVendas() throws IOException
    {
    	 List<Venda> listaVendas = vendaDAO.listar();
            for (Venda vendas : listaVendas)
    		{
    			System.out.println(vendas);
    			FileWriter gerarVenda = new FileWriter("C:\\Users\\lucas\\OneDrive\\Documentos\\UP\\Java\\CSV\\vendas.csv", true);
    		        
    	        PrintWriter gravadorVenda = new PrintWriter(gerarVenda);
    	        gravadorVenda.println(vendas + "\n");  	        
    	        gravadorVenda.close();
    		}
    }
}
