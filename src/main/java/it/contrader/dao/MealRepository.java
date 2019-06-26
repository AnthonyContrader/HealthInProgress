package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Meal;
import it.contrader.model.Parameter;

/**
 * Estende CrudRepository ed eredita tutti i metodi di CRUD. 
 * Definisce il metodo di login.
 * 
 * 
 * @see CrudRepository
 *
 */
@Repository
@Transactional
public interface MealRepository extends CrudRepository<Meal, Long>{


	Meal findById(long id);
	
}
