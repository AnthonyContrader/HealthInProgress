
package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {

	private Integer idIngredient;

	private String nome;
	
	
	private UserDTO userDTO;
	private MealDTO mealDTO;


	

}