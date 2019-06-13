package it.contrader.dao;
import it.contrader.model.Sport;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SportDAO {

	private final String QUERY_ALL = "select * from sports";
	private final String QUERY_INSERT = "insert into sports (nome, tipo, durata) values (?,?,?)";
	private final String QUERY_READ = "select * from sports where idsport=?";

	private final String QUERY_UPDATE = "UPDATE sports SET nome=?, tipo=?, durata=?";
	private final String QUERY_DELETE = "delete from sports where idsport=?";

	public SportDAO() {

	}

	public List<Sport> getAllSport() {
		List<Sport> sportsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Sport sport;
			while (resultSet.next()) {
				int idsport = resultSet.getInt("idsport");
				String nome = resultSet.getString("nome");
				String tipo = resultSet.getString("tipo");
				double durata = resultSet.getDouble("durata");
				sport = new Sport(nome, tipo, durata);
				sport.setIdsport(idsport);
				sportsList.add(sport);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sportsList;
	}

	public boolean insertSport(Sport sport) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, sport.getNome());
			preparedStatement.setString(2, sport.getTipo());
			preparedStatement.setDouble(3, sport.getDurata());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Sport readSport(Sport sport) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int idsport = sport.getIdsport();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idsport);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String nome, tipo;
			double durata;

			nome = resultSet.getString("nome");
			tipo = resultSet.getString("tipo");
			durata = resultSet.getDouble("durata");
			sport = new Sport(nome, tipo, durata);
			sport.setIdsport(resultSet.getInt("idsport"));

			return sport;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateSport(Sport sportToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (sportToUpdate.getIdsport() == 0)
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
			preparedStatement.setString(1, sportToUpdate.getNome());
			preparedStatement.setString(2, sportToUpdate.getTipo());
			preparedStatement.setDouble(3, sportToUpdate.getDurata());
			preparedStatement.setInt(7, sportToUpdate.getIdsport());

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

	public boolean deleteSport(Sport sport) {
		int id = sport.getIdsport();
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

	public Sport login(String nome, String tipo, Double durata) {
		// TODO Auto-generated method stub
		return null;
	}

	
}