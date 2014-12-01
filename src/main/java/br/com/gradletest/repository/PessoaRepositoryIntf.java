package br.com.gradletest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gradletest.entity.Pessoa;

/**
 * @author Adriano S. Bonfiglio
 *
 */
public interface PessoaRepositoryIntf extends CrudRepository<Pessoa, Serializable> {

	/**
	 * Executa query automaticamente escrevendo o método como nome do atributo
	 * 
	 * @param email
	 * @return
	 */
	Pessoa findByEmailLike(String email);
	
	/*
	 * @see CrudRepository#findAll()
	 */
	List<Pessoa> findAll();
}
