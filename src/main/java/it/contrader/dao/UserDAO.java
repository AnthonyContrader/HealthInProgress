package it.contrader.dao;

import java.sql.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import it.contrader.model.User;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;


public class UserDAO {

	private final String QUERY_ALL = "select * from users";

	private final String QUERY_INSERT = "insert into users (Nome,Password,Tipo) values (?,?,?)";

	private final String QUERY_READ = "select * from users where Iduser=?";

	private final String QUERY_UPDATE = "UPDATE users set Nome=?,Password=?,Tipo=? WHERE Iduser=?";

	private final String QUERY_DELETE = "delete from users where Iduser=?";

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

				int userId = resultSet.getInt("Iduser");

				String username = resultSet.getString("Nome");

				String usertype = resultSet.getString("tipo");

				String password = resultSet.getString("Password");

				user = new User( username, usertype, password);

				user.setIduser(userId);

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

	public User readUser(int userId) {

		Connection connection = ConnectionSingleton.getInstance();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);

			preparedStatement.setInt(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();

			String username, password, usertype;

			username = resultSet.getString("Nome");
			password = resultSet.getString("Password");

			usertype = resultSet.getString("Tipo");

			User user = new User(username, password, usertype);

			user.setIduser(resultSet.getInt("Iduser"));

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

		User userRead = readUser(userToUpdate.getIduser());

		if (!userRead.equals(userToUpdate)) {

			try {

				// Fill the userToUpdate object

				if (userToUpdate.getNome() == null || userToUpdate.getNome().equals("")) {

					userToUpdate.setNome(userRead.getNome());

				}

				if (userToUpdate.getTipo() == null || userToUpdate.getTipo().equals("")) {

					userToUpdate.setTipo(userRead.getTipo());

				}

				// Update the user

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);

				preparedStatement.setString(1, userToUpdate.getNome());
				preparedStatement.setString(2, userToUpdate.getPassword());

				preparedStatement.setString(3, userToUpdate.getTipo());

				preparedStatement.setInt(4, userToUpdate.getIduser());

				int a = preparedStatement.executeUpdate();

				if (a > 0)

					return true;

				else

					return false;

			} catch (SQLException e) {

				return false;

			}

		}

		return false;

	}

	public boolean deleteUser(Integer id) {

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

}