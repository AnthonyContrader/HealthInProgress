
package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Meal;
import it.contrader.model.User;

public interface MealRepository extends CrudRepository<Meal, Integer> {

	public List<Meal> findAllByUser(User user);
}