package it.contrader.dao;

import it.contrader.model.User;

import it.contrader.utils.ConnectionSingleton;

import it.contrader.utils.GestoreEccezioni;



import java.sql.*;

import java.util.ArrayList;

import java.util.List;



public class UserDAO {



	private final String QUERY_ALL = "select * from users";

	private final String QUERY_INSERT = "insert into users (nome,password,tipo) values (?,?,?)";

	private final String QUERY_READ = "select * from users where iduser=?";



	private final String QUERY_UPDATE = "UPDATE users SET nome=?, password=?,tipo=? WHERE iduser=?";

	private final String QUERY_DELETE = "delete from users where iduser=?";

	private final String QUERY_LOGIN = "select * from users where nome=? and password=?";
	
	private final String QUERY_REGISTER = "insert into users (nome,password,tipo) values (?,?,?)";





	public UserDAO() {



	}



	public List<User> getAllUser() {

		List<User> usersList = new ArrayList<>();

		Connection connection = ConnectionSingleton.getInstance();

		try {

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(QUERY_ALL);

			User user;

			while (resultSet.next()) {

				int iduser = resultSet.getInt("iduser");

				String nome = resultSet.getString("nome");

				String password = resultSet.getString("password");

				String tipo = resultSet.getString("tipo");


				user = new User(nome, tipo,password);

				user.setIduser(iduser);

				usersList.add(user);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return usersList;

	}



	public boolean insertUser(User user) {

		Connection connection = ConnectionSingleton.getInstance();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);

			preparedStatement.setString(1, user.getNome());

			preparedStatement.setString(2, user.getPassword());

			preparedStatement.setString(3, user.getTipo());

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return false;

		}



	}



	public User readUser(User user) {

		Connection connection = ConnectionSingleton.getInstance();

		try {

			int iduser = user.getIduser();

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);

			preparedStatement.setInt(1, iduser);

			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();

			String nome,tipo,password;



			nome = resultSet.getString("nome");

			tipo = resultSet.getString("tipo");

			password = resultSet.getString("password");

			

			user = new User(nome,tipo,password);

			user.setIduser(resultSet.getInt("iduser"));



			return user;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return null;

		}



	}



	public boolean updateUser(User userToUpdate) {

		Connection connection = ConnectionSingleton.getInstance();



		// Check if id is present

		if (userToUpdate.getIduser() == 0)

			return false;



		// User userRead = readUser(userToUpdate);

		// if (!userRead.equals(userToUpdate)) {

		try {

			// Fill the userToUpdate object

			/*

			if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {

			 

				userToUpdate.setUser(userRead.getUsername());

			}



			if (userToUpdate.getPassword() == null || userToUpdate.getPassword().equals("")) {

				userToUpdate.setPassword(userRead.getPassword());

			}



			if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {

				userToUpdate.setUsertype(userRead.getUsertype());

			}

			

			*/

			// Update the user

			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);

			preparedStatement.setString(1, userToUpdate.getNome());

			preparedStatement.setString(2, userToUpdate.getTipo());

			preparedStatement.setString(3, userToUpdate.getPassword());
			preparedStatement.setInt(4,userToUpdate.getIduser());
		

			int a = preparedStatement.executeUpdate();

			if (a > 0)

				return true;

			else

				return false;



		} catch (SQLException e) {

			return false;

		}

		//}



		//return false;



	}



	public boolean deleteUser(User user) {

		int id = user.getIduser();

		Connection connection = ConnectionSingleton.getInstance();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);

			preparedStatement.setInt(1, id);

			int n = preparedStatement.executeUpdate();

			if (n != 0)

				return true;

		} catch (SQLException e) {

		}

		return false;

	}



	public User login(String nome, String password) {



		Connection connection = ConnectionSingleton.getInstance();

		User utente = null;

		try {

			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);

			statement.setString(1, nome);

			statement.setString(2, password);

			statement.execute();

			ResultSet resultSet = statement.getResultSet();



			while (resultSet.next()) {

				int userId=resultSet.getInt("iduser");

				 String usernameS = resultSet.getString("nome");
				 String passwordS = resultSet.getString("password");

				String usertypeS = resultSet.getString("tipo");

				

				utente = new User(usernameS, usertypeS,passwordS);

				utente.setIduser(userId);

			}



		} catch (SQLException e) {

			e.printStackTrace();

		}

		return utente;

	}

	public boolean registerUser(User user) {

		Connection connection = ConnectionSingleton.getInstance();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_REGISTER);

			preparedStatement.setString(1, user.getNome());

			preparedStatement.setString(2, user.getPassword());

			preparedStatement.setString(3, "user");

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return false;

		}



	}
}
