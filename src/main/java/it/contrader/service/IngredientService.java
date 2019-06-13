package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ConverterIngredient;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.IngredientDAO;
import it.contrader.dao.IngredientDAO;
import it.contrader.dto.IngredientDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Ingredient;
import it.contrader.model.User;

public class IngredientService {

	private IngredientDAO ingredientDAO;

	public IngredientService() {
		this.ingredientDAO = new IngredientDAO();
	}

	public List<IngredientDTO> getAllIngredient() {



		List<Ingredient> list = ingredientDAO.getAllIngredient();

		List<IngredientDTO> listDTO = new ArrayList<>();



		for (Ingredient ingredient : list) {

			listDTO.add(ConverterIngredient.toDTO(ingredient));

		}



		return listDTO;

	}

	

	public boolean insertIngredient(IngredientDTO ingredientDTO) {
		return this.ingredientDAO.insertIngredient(ConverterIngredient.toEntity(ingredientDTO));
	}
	
	public IngredientDTO readIngredient(IngredientDTO ingredientDTO) {

		return ConverterIngredient.toDTO(this.ingredientDAO.readIngredient(ConverterIngredient.toEntity(ingredientDTO)));
	}
	
	public boolean updateIngredient(IngredientDTO ingredientDTO) {
		return this.ingredientDAO.updateIngredient(ConverterIngredient.toEntity(ingredientDTO));
	}
	
	public boolean deleteIngredient(IngredientDTO ingredientDTO) {

		return this.ingredientDAO.deleteIngredient(ConverterIngredient.toEntity(ingredientDTO));

		
	}

	
	
}
