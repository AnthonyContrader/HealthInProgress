package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterUser;
import it.contrader.dao.ParametersDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

public class UserService {

	private ParametersDAO userDAO;

	public UserService() {
		this.userDAO = new ParametersDAO();
	}

	public List<User> getAllUser() {
		return this.userDAO.getAllUser();
	}

	public boolean insertUser(UserDTO userDTO) {
		return this.userDAO.insertUser(ConverterUser.toEntity(userDTO));
	}
	
	public UserDTO readUser(int userId) {
		return ConverterUser.toDTO(this.userDAO.readUser(userId));
	}
	
	public boolean updateUser(UserDTO userDTO) {
		return this.userDAO.updateUser(ConverterUser.toEntity(userDTO));
	}
	
	public boolean deleteUser(int userId) {
		return this.userDAO.deleteUser(userId);
	}
	
	
}
