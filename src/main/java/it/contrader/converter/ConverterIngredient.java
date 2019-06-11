package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.IngredientDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Ingredient;
import it.contrader.model.User;

public class ConverterIngredient {

	public static IngredientDTO toDTO(Ingredient ingredient) {
		IngredientDTO ingredientDTO = null;
		if (ingredient != null) {
			ingredientDTO = new IngredientDTO(ingredient.getNome());
			ingredientDTO.setIdingredient(ingredient.getIdingredient());;
			
		}
		return ingredientDTO;
		

		
		
	}

	public static Ingredient toEntity(IngredientDTO ingredientDTO) {
		Ingredient ingredient = null;
		if (ingredientDTO != null) {
			ingredient = new Ingredient();
			ingredient.setIdingredient(ingredientDTO.getIdingredient());
			ingredient.setNome(ingredientDTO.getNome());
			
		}
		return ingredient;
	}

	public static  List<IngredientDTO> toListDTO(List<Ingredient> list) {
		List<IngredientDTO> listIngredientDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Ingredient ingredient : list) {
				listIngredientDTO.add(ConverterIngredient.toDTO(ingredient));
			
		}
		}
		
		return listIngredientDTO;
	}

	public static List<Ingredient> toListEntity(List<IngredientDTO> listIngredientDTO) {
		List<Ingredient> list = new ArrayList<>();
		if (!listIngredientDTO.isEmpty()) {
			for (IngredientDTO ingredientDTO : listIngredientDTO) {
				list.add(ConverterIngredient.toEntity(ingredientDTO));
			}
		}
		return list;
	}
}

