package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import it.contrader.model.User;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {

	private Integer id;

	private String nome;

	private UserDTO userDTO;



	

}