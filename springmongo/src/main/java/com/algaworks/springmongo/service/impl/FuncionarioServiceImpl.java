package com.algaworks.springmongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.springmongo.model.Funcionario;
import com.algaworks.springmongo.repository.FuncionarioRepository;
import com.algaworks.springmongo.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public List<Funcionario> obterTodos() {
		return this.funcionarioRepository.findAll();
	}

	@Override
	public Funcionario obterPorCodigo(String codigo) {
		return funcionarioRepository.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Funcionario não existe"));
	}

	@Override
	public Funcionario criar(Funcionario funcionario) {

		Funcionario chefe = funcionarioRepository.findById(funcionario.getChefe().getCodigo())
				.orElseThrow(() -> new IllegalArgumentException("Chefe não existe"));

		funcionario.setChefe(chefe);

		return funcionarioRepository.save(funcionario);
	}

	@Override
	public List<Funcionario> obterFuncionariosPorRangeDeIdade(Integer de, Integer ate) {
		return funcionarioRepository.obterFuncionariosPorRangeDeIdade(de, ate);
	}

	@Override
	public List<Funcionario> obterFuncionariosPorNome(String nome) {
		return funcionarioRepository.findByNome(nome);
	}

}
