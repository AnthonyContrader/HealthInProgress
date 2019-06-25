
package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Device;
import it.contrader.model.Ingredient;
import it.contrader.model.Meal;
import it.contrader.model.User;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

	public List<Ingredient> findAllByMeal(Meal meal);
}