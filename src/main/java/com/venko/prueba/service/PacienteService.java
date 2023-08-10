package com.venko.prueba.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.venko.prueba.model.Paciente;
import com.venko.prueba.repository.PacienteRepository;

@Service
public class PacienteService implements PacienteRepository{
	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Paciente> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Paciente> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Paciente> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paciente getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Paciente> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Paciente> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Paciente> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> findAll() {
		// TODO Auto-generated method stub
		return pacienteRepository.findAll();
	}

	@Override
	public List<Paciente> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return pacienteRepository.findAllById(ids);
	}

	@Override
	public <S extends Paciente> S save(S entity) {
		// TODO Auto-generated method stub
		return pacienteRepository.save(entity);
	}

	@Override
	public Optional<Paciente> findById(Long id) {
		// TODO Auto-generated method stub
		return pacienteRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Paciente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Paciente> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Paciente> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return pacienteRepository.findAll();
	}

	@Override
	public Page<Paciente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Paciente> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Paciente> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Paciente> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Paciente> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Paciente, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
