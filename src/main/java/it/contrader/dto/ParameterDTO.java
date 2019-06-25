 package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParameterDTO {

	private Integer Id;
	private String sesso;
	private Integer altezza;
	private Integer peso;
	private Integer eta;
	private String totKcal;

	private UserDTO userDTO;

	

}