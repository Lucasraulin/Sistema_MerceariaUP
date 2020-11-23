package br.edu.up.DAO;

import java.util.List;

public interface DAO<T> 
{	
	T salvar(T entidade);
	T atualizar(T entidade);
	T buscarPorId(String id);
	List<T> listar();
	void apagar(String id);
}
