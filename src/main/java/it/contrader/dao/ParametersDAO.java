package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;

import java.util.Vector;

import it.contrader.controller.GestoreEccezioni;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Parameters;

public class ParametersDAO {

	private final String QUERY_ALL = "select * from parameters";

	private final String QUERY_INSERT = "insert into parameters (nome,sesso,dispositivo,altezza,peso,eta,polso,freqResp,tempCorp,ossSang) values (?,?,?,?)";

	private final String QUERY_READ = "select * from users where idParameters=?";

	private final String QUERY_UPDATE = "UPDATE nome=?,sesso=?,dispositivo=?,altezza=?,peso=?,eta=?,polso=?,freqResp=?,tempCorp,ossSang=?,=?, WHERE idParameters=?";

	private final String QUERY_DELETE = "delete from user where idParameters=?";

	public ParametersDAO() {

	}

	public List<Parameters> getAllParameters() {

		List<Parameters> parametersList = new ArrayList<>();

		Connection connection = ConnectionSingleton.getInstance();

		try {

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(QUERY_ALL);

			Parameters parameters;

			while (resultSet.next()) {

				int parametersId = resultSet.getInt("idparameters");

				String name = resultSet.getString("nome");
				String sex = resultSet.getString("sesso");

				String device = resultSet.getString("dispositivo");
				double height = resultSet.getDouble("altezza");
				double weight = resultSet.getDouble("peso");
				int eta = resultSet.getInt("eta");
				int polso = resultSet.getInt("polso");
				int respiratoryR = resultSet.getInt("freqResp");
				int bodyT = resultSet.getInt("tempCorp");
				int bloodO = resultSet.getInt("ossSang");

				parameters = new Parameters(parametersId, name, sex, device, height, weight, eta, polso, respiratoryR,bodyT, bloodO);
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

			User user = new User(userId, username, password, usertype);

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