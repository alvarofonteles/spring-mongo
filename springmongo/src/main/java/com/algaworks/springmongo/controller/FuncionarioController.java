package com.algaworks.springmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.springmongo.model.Funcionario;
import com.algaworks.springmongo.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping
	public List<Funcionario> obterTodos() {
		return funcionarioService.obterTodos();
	};

	@GetMapping("/{codigo}")
	public Funcionario obterPorCodigo(@PathVariable("codigo") String codigo) {
		return funcionarioService.obterPorCodigo(codigo);
	};

	@PostMapping
	public Funcionario criar(@RequestBody Funcionario funcionario) {
		return funcionarioService.criar(funcionario);
	};

}
