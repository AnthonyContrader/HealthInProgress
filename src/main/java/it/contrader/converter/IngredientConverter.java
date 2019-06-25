package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.IngredientDTO;

import it.contrader.model.Ingredient;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class IngredientConverter extends AbstractConverter<Ingredient,IngredientDTO> {

	@Override
	public Ingredient toEntity(IngredientDTO ingredientDTO) {
		Ingredient ingredient = null;
		if (ingredientDTO != null) {
			ingredient = new Ingredient(ingredientDTO.getId(),ingredientDTO.getName());			
		}
		return ingredient;
	}

	@Override
	public IngredientDTO toDTO(Ingredient ingredient) {
		IngredientDTO ingredientDTO = null;
		if (ingredient != null) {
			ingredientDTO = new IngredientDTO(ingredient.getId(),ingredient.getName());
			
		}
		return ingredientDTO;
	}

	
}