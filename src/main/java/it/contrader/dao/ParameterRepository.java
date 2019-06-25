 package it.contrader .dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Parameter;
import it.contrader.model.User;

public interface ParameterRepository extends CrudRepository<Parameter, Integer> {

	public List<Parameter> findAllByUser(User user);
	
}