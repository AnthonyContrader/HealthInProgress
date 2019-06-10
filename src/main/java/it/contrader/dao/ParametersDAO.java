package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;
import java.util.Vector;

import it.contrader.controller.GestoreEccezioni;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Parameters;
import it.contrader.model.User;

public class ParametersDAO {

	private final String QUERY_ALL = "select * from parameters";

	private final String QUERY_INSERT = "insert into parameters (sesso,altezza,peso,eta,polso,freqResp,tempCorp) values (?,?,?,?,?,?,?)";

	private final String QUERY_READ = "select * from parameters where idParameter=?";

	private final String QUERY_UPDATE = "UPDATE parameters set sesso=?,altezza=?,peso=?,eta=?,polso=?,freqResp=?,tempCorp,=?, WHERE idParameter=?";

	private final String QUERY_DELETE = "delete from parameters where idParameter=?";

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

				int parametersId = resultSet.getInt("idParameter");
				String sex = resultSet.getString("sesso");
				double height = resultSet.getDouble("altezza");
				double weight = resultSet.getDouble("peso");
				int age = resultSet.getInt("eta");
				int pulse = resultSet.getInt("polso");
				int respiratoryR = resultSet.getInt("freqResp");
				int bodyT = resultSet.getInt("tempCorp");

				parameters = new Parameters(parametersId, sex, height, weight, age, pulse, respiratoryR, bodyT);
				parameters.setIdParameter(parametersId);

				parametersList.add(parameters);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return parametersList;

	}

	public boolean insertParameters(Parameters parameters) {

		Connection connection = ConnectionSingleton.getInstance();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);

			preparedStatement.setString(1, parameters.getSesso());
			preparedStatement.setDouble(2, parameters.getAltezza());
			preparedStatement.setDouble(3, parameters.getPeso());
			preparedStatement.setInt(4, parameters.getEta());
			preparedStatement.setInt(5, parameters.getPolso());
			preparedStatement.setInt(6, parameters.getFreqResp());
			preparedStatement.setInt(7, parameters.getTempCorp());

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return false;

		}

	}

	public Parameters readParameters(int idParameter) {

		Connection connection = ConnectionSingleton.getInstance();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);

			preparedStatement.setInt(1, idParameter);

			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();

			String sex;
			int idparameter;
			int age, pulse, respiratoryr, bodyt;
			double height, weight;
			
			idparameter = resultSet.getInt("idParameter");
			sex = resultSet.getString("sesso");
			height = resultSet.getDouble("altezza");
			weight = resultSet.getDouble("peso");
			age = resultSet.getInt("eta");
			pulse = resultSet.getInt("polso");
			respiratoryr = resultSet.getInt("freqResp");
			bodyt = resultSet.getInt("tempCorp");

			Parameters parameters = new Parameters(idparameter, sex, height, weight, age, pulse, respiratoryr, bodyt);

			parameters.setIdParameter(resultSet.getInt("idParameter"));

			return parameters;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return null;

		}

	}

	public boolean updateParameters(Parameters parametersToUpdate) {

		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present

		if (parametersToUpdate.getIdParameter() == 0)

			return false;


			try {

				// Fill the userToUpdate object


				// Update the user

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);

				preparedStatement.setString(1, parametersToUpdate.getSesso());
				preparedStatement.setDouble(2, parametersToUpdate.getAltezza());

				preparedStatement.setDouble(3, parametersToUpdate.getPeso());

				preparedStatement.setInt(4, parametersToUpdate.getEta());
				preparedStatement.setInt(5, parametersToUpdate.getPolso());
				preparedStatement.setInt(6, parametersToUpdate.getFreqResp());
				preparedStatement.setInt(7, parametersToUpdate.getTempCorp());

				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		

		
	}

	public boolean deleteParameters(Integer id) {

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

