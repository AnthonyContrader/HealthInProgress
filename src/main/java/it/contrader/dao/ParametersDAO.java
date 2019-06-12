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

import it.contrader.model.Parameters;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;


public class ParametersDAO {

	private final String QUERY_ALL = "select * from parameters";

	private final String QUERY_INSERT = "insert into parameters (sesso,altezza,peso,eta,polso,freqResp,tempCorp) values (?,?,?,?,?,?,?)";

	private final String QUERY_READ = "select * from parameters where idParameter=?";

	private final String QUERY_UPDATE = "UPDATE parameters set sesso=?,altezza=?,peso=?,eta=?,polso=?,freqResp=?,tempCorp=? WHERE idParameter=?";

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
				String sesso = resultSet.getString("sesso");
				double altezza = resultSet.getDouble("altezza");
				double peso = resultSet.getDouble("peso");
				int eta = resultSet.getInt("eta");
				int polso = resultSet.getInt("polso");
				int freqResp = resultSet.getInt("freqResp");
				int tempCorp = resultSet.getInt("tempCorp");

				parameters = new Parameters( sesso,altezza,peso,eta,polso,freqResp,tempCorp);
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

	public Parameters readParameters(Parameters	parameters) {

		Connection connection = ConnectionSingleton.getInstance();

		try {
			int parametersId = parameters.getIdParameter();

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);

			preparedStatement.setInt(1, parametersId);

			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();

			String sex;
			int idparameter;
			int age, pulse, respiratoryr, bodyt;
			double height, weight;
			
			sex = resultSet.getString("sesso");
			height = resultSet.getDouble("altezza");
			weight = resultSet.getDouble("peso");
			age = resultSet.getInt("eta");
			pulse = resultSet.getInt("polso");
			respiratoryr = resultSet.getInt("freqResp");
			bodyt = resultSet.getInt("tempCorp");

			parameters = new Parameters(sex, height, weight, age, pulse, respiratoryr, bodyt);

			parameters.setIdParameter(resultSet.getInt("idParameter"));

			return parameters;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return null;

		}

	}
	//GIT
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
				preparedStatement.setInt(8, parametersToUpdate.getIdParameter());

				int a = preparedStatement.executeUpdate();

				if (a > 0)

					return true;

				else

					return false;

			} catch (SQLException e) {

				return false;
		
			}
	}
		
	

	public boolean deleteParameters(Parameters	parameters) {
		int id = parameters.getIdParameter();
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

