package it.contrader.dto;



import java.util.List;





import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;



@Data

@AllArgsConstructor

@NoArgsConstructor

public class UserDTO {



	

	private int id;



	private String username;



	private String password;



	private String usertype;

	


	public UserDTO( String username, String password, String usertype
			) {

		super();

		this.username = username;

		this.password = password;

		this.usertype = usertype;

		
	}

	


	

	

}