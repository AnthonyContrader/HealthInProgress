package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterIngredient;
import it.contrader.dao.IngredientDAO;
import it.contrader.dao.IngredientDAO;
import it.contrader.dto.IngredientDTO;
import it.contrader.model.Ingredient;

public class IngredientService {

	private IngredientDAO ingredientDAO;

	public IngredientService() {
		this.ingredientDAO = new IngredientDAO();
	}

	public List<Ingredient> getAllIngredient() {
		return this.ingredientDAO.getAllIngredient();
	}

	public boolean insertIngredient(IngredientDTO ingredientDTO) {
		return this.ingredientDAO.insertIngredient(ConverterIngredient.toEntity(ingredientDTO));
	}
	
	public IngredientDTO readIngredient(int idingredient) {
		return ConverterIngredient.toDTO(this.ingredientDAO.readIngredient(idingredient));
	}
	
	public boolean updateIngredient(IngredientDTO ingredientDTO) {
		return this.ingredientDAO.updateIngredient(ConverterIngredient.toEntity(ingredientDTO));
	}
	
	public boolean deleteIngredient(int idingredient) {
		return this.ingredientDAO.deleteIngredient(idingredient);
	}
	
	
}
