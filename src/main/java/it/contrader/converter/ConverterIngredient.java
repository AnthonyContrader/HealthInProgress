package it.contrader.converter;

import it.contrader.dto.IngredientDTO;

import it.contrader.model.Ingredient;



/**

 * Il converter si occupa di "convertire" un model in un dto e viceversa

 *

 */

public class ConverterIngredient {



	/**

	 * Converte un NodesDTO in Nodes

	 */

	public static Ingredient toEntity(IngredientDTO ingredientDTO) {



		Ingredient ingredient= null;

		if (ingredientDTO != null) {

		 ingredient = new Ingredient(ingredientDTO.getNome());

			if (ingredientDTO.getIdingredient() != 0)

			ingredient.setIdingredient(ingredientDTO.getIdingredient());

		}
		

		

		return ingredient;

	}



	/**

	 * Converte un Nodes in NodesDTO

	 */



	public static IngredientDTO toDTO(Ingredient ingredient) {



		IngredientDTO ingredientDTO= null ;

		if (ingredient != null) {

			ingredientDTO = new IngredientDTO(ingredient.getNome());

			ingredientDTO.setIdingredient(ingredient.getIdingredient());

			// userDTO.setId(user.getUserId());

		}



		return ingredientDTO;

	}





}

