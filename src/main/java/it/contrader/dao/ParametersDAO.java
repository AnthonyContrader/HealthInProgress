package it.contrader.dao;

import java.sql.*;


import java.util.ArrayList;

import java.util.List;

import it.contrader.controller.GestoreEccezioni;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Parameters;


public class ParametersDAO {

	private final String QUERY_ALL = "select * from parameters";

	private final String QUERY_INSERT = "insert into parameters (nome,sesso,dispositivo,altezza,peso,eta,polso,freqResp,tempCorp,ossSang) values (?,?,?,?,?,?,?,?,?,?)";

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
				int age = resultSet.getInt("eta");
				int pulse = resultSet.getInt("polso");
				int respiratoryR = resultSet.getInt("freqResp");
				int bodyT = resultSet.getInt("tempCorp");
				int bloodO = resultSet.getInt("ossSang");

				parameters = new Parameters( name, sex, device, height, weight, age, pulse, respiratoryR,
						bodyT, bloodO);
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

			preparedStatement.setString(1, parameters.getNome());
			preparedStatement.setString(2, parameters.getSesso());
			preparedStatement.setString(3, parameters.getDispositivo());
			preparedStatement.setDouble(4, parameters.getAltezza());
			preparedStatement.setDouble(5, parameters.getPeso());
			preparedStatement.setInt(6, parameters.getEta());
			preparedStatement.setInt(7, parameters.getPolso());
			preparedStatement.setInt(8, parameters.getFreqResp());
			preparedStatement.setInt(9, parameters.getTempCorp());
			preparedStatement.setInt(10, parameters.getOssSang());

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

			String name, sex, device;
			int age, pulse, respiratoryr, bodyt, bloodo;
			double height, weight;

			name = resultSet.getString("nome");
			sex = resultSet.getString("sesso");
			device = resultSet.getString("dispositivo");
			height = resultSet.getDouble("altezza");
			weight = resultSet.getDouble("peso");
			age = resultSet.getInt("eta");
			pulse = resultSet.getInt("polso");
			respiratoryr = resultSet.getInt("freqResp");
			bodyt = resultSet.getInt("tempCorp");
			bloodo = resultSet.getInt("ossSang");
			Parameters parameters = new Parameters(name, sex, device, height, weight, age, pulse, respiratoryr, bodyt,
					bloodo);

			parameters.setIdParameter(resultSet.getInt("idParameters"));

			return parameters;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return null;

		}

	}

	public boolean updateparameters(Parameters parametersToUpdate) {

		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present

		if (parametersToUpdate.getIdParameter() == 0) 

			return false;
		
		// Update the user
		try {

		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);

		preparedStatement.setString(1, parametersToUpdate.getNome());
		preparedStatement.setString(2, parametersToUpdate.getSesso());

		preparedStatement.setString(3, parametersToUpdate.getDispositivo());

		preparedStatement.setDouble(4, parametersToUpdate.getAltezza());
		preparedStatement.setDouble(4, parametersToUpdate.getPeso());
		preparedStatement.setInt(4, parametersToUpdate.getEta());
		preparedStatement.setInt(4, parametersToUpdate.getPolso());
		preparedStatement.setInt(4, parametersToUpdate.getFreqResp());
		preparedStatement.setInt(4, parametersToUpdate.getTempCorp());
		preparedStatement.setInt(4, parametersToUpdate.getOssSang());
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