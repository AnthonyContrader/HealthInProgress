
package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Ingredient;
import it.contrader.model.Meal;
import it.contrader.model.User;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

	//public List<Meal> findAllByUser(User user);
	//public List<User> findAllByUser(String  name);

}