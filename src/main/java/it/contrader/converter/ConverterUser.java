package it.contrader.converter;



import it.contrader.dto.UserDTO;

import it.contrader.model.User;



/**

 * Il converter si occupa di "convertire" un model in un dto e viceversa

 *

 */

public class ConverterUser {



	/**

	 * Converte un NodesDTO in Nodes

	 */

	public static User toEntity(UserDTO userDTO) {



		User user= null;

		if (userDTO != null) {

			user = new User(userDTO.getNome(),userDTO.getPassword(),userDTO.getTipo());

			if (userDTO.getIduser() != 0)

			user.setIduser(userDTO.getIduser());

		}
		

		

		return user;

	}



	/**

	 * Converte un Nodes in NodesDTO

	 */



	public static UserDTO toDTO(User user) {



		UserDTO userDTO= null ;

		if (user != null) {

			userDTO = new UserDTO(user.getNome(),  user.getTipo(),user.getPassword());

			userDTO.setIduser(user.getIduser());

			// userDTO.setId(user.getUserId());

		}



		return userDTO;

	}



}