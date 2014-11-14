package br.com.gradletest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gradletest.entity.Pessoa;
import br.com.gradletest.repository.PessoaRepositoryIntf;

/**
 * @author Adriano S. Bonfiglio
 *
 */
public class PessoaService {
	
	@Autowired
	PessoaRepositoryIntf pessoaRepository;
	
	/**
	 * @param email
	 * @return
	 */
	public Pessoa findByEmail(String email) {
		Pessoa pessoa = pessoaRepository.findByEmail(email);
		return pessoa;
	}
	
	/**
	 * @return
	 */
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}
 
}
