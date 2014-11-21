package br.com.gradletest.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.gradletest.entity.Pessoa;
import br.com.gradletest.repository.PessoaRepositoryIntf;

/**
 * @author Adriano S. Bonfiglio
 *
 */
@Service
public class PessoaService implements PessoaRepositoryIntf {
	
	@Resource
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

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Serializable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pessoa arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Pessoa> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Serializable arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Pessoa> findAll(Iterable<Serializable> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa findOne(Serializable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pessoa> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pessoa> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
