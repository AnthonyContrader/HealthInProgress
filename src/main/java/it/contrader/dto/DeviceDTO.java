package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {

	private Integer idDevice;

	private String nome;

	private UserDTO userDTO;



	

}