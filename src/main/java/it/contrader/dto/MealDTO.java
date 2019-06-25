
package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealDTO {

	private Integer idPiatto;

	private String nome;
	
	private Integer kcal;
	
	private String tipo;
	
private UserDTO userDTO;



	

}