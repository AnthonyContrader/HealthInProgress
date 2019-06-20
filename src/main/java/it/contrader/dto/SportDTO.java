
package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SportDTO {

	private Integer idSport;

	private String nome;
	
	private String tipo;
	
	private Integer durata;

	private UserDTO userDTO;



	

}