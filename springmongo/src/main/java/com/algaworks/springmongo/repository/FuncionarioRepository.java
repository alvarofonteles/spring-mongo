package com.algaworks.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.algaworks.springmongo.model.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

}
