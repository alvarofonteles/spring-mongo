package com.algaworks.springmongo.service;

import java.util.List;

import com.algaworks.springmongo.model.Funcionario;

public interface FuncionarioService {
	
	public List<Funcionario> obterTodos();
	
	public Funcionario obterPorCodigo(String codigo);
	
	public Funcionario criar(Funcionario funcionario);

}
