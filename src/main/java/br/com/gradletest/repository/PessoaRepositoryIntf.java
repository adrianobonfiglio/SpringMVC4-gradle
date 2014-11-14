package br.com.gradletest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.gradletest.entity.Pessoa;

/**
 * @author Adriano S. Bonfiglio
 *
 */
public interface PessoaRepositoryIntf extends CrudRepository<Pessoa, Serializable> {

	/**
	 * Executa query automaticamente escrevendo o m�todo como nome do atributo
	 * 
	 * @param email
	 * @return
	 */
	Pessoa findByEmail(String email);
	
	/*
	 * @see CrudRepository#findAll()
	 */
	List<Pessoa> findAll();
}
