package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParameterDTO {

	private Integer IdParameter;
	private String sesso;
	private Integer altezza;
	private Integer peso;
	private Integer eta;
	private Integer totKcal;

	private UserDTO userDTO;

	

}