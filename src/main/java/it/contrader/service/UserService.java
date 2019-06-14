package it.contrader.service;





import java.util.ArrayList;

import java.util.*;



import it.contrader.converter.ConverterUser;

import it.contrader.dao.UserDAO;

import it.contrader.dto.UserDTO;

import it.contrader.model.User;



/**

 * Classe che si occupa di interfacciarsi con la persistenza e recuperare

 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte

 * in un oggetto DTO e le restituisce al controller opportuno

 */

public class UserService {



	private final UserDAO userDAO;



	public UserService() {

		this.userDAO = new UserDAO();

	}



	/**

	 * Come vediamo la lista recuperata � di tipo Esempio ma noi la convertiamo in EsempioDTO

	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perch� � sporco e poco efficiente

	 */

	public List<UserDTO> getAllUsers() {



		List<User> list = userDAO.getAllUser();

		List<UserDTO> listDTO = new ArrayList<>();



		for (User user : list) {

			listDTO.add(ConverterUser.toDTO(user));

		}



		return listDTO;

	}

	

	public UserDTO getUserByNomeAndPassword(String nome, String password) {

		return ConverterUser.toDTO(userDAO.login(nome, password));

	}



	public UserDTO readUser(UserDTO userDTO) {

		return ConverterUser.toDTO(this.userDAO.readUser(ConverterUser.toEntity(userDTO)));

	}

	

	public boolean updateUser(UserDTO userDTO) {

		return this.userDAO.updateUser(ConverterUser.toEntity(userDTO));

		

}

	

	public boolean deleteUsers (UserDTO userDTO) {

		return this.userDAO.deleteUser(ConverterUser.toEntity(userDTO));

		

}

	

	public boolean insertUser (UserDTO usersDTO) {

		return this.userDAO.insertUser(ConverterUser.toEntity(usersDTO));

	

}
	





		

	

	

}