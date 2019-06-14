package it.contrader.dao;

import it.contrader.model.Parameters;
import it.contrader.model.Sport;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SportDAO {

	private final String QUERY_ALL = "select * from sport";
	private final String QUERY_INSERT = "insert into sport (nome,tipo,durata) values (?,?,?)";
	private final String QUERY_READ = "select * from sport where idsport=?";

	private final String QUERY_UPDATE = "UPDATE sport set nome=?,tipo=?,durata=? WHERE idsport=?";
	private final String QUERY_DELETE = "delete from sport where idsport=?";
	public SportDAO() {

	}

	public List<Sport> getAllSport() {
		List<Sport> sportList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Sport sport;
			while (resultSet.next()) {
				int Idsport = resultSet.getInt("Idsport");
				int tipo = resultSet.getInt("tipo");
				int durata = resultSet.getInt("durata");
				String nome = resultSet.getString("nome");
				
				sport = new Sport(nome,tipo,durata);
				sport.setIdsport(Idsport);
				sportList.add(sport);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sportList;
	}

	public boolean insertSport(Sport sport) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, sport.getNome());
			preparedStatement.setInt(2, sport.getTipo());
			preparedStatement.setInt(3, sport.getDurata());
			
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
			int Idsport = sport.getIdsport();

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);

			preparedStatement.setInt(1, Idsport);

			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();

			String nome;
			int idsport;
			int tipo, durata;
			
			
			nome = resultSet.getString("nome");
			tipo = resultSet.getInt("tipo");
			durata = resultSet.getInt("durata");
			

			sport = new Sport(nome,tipo,durata);

			sport.setIdsport(resultSet.getInt("idSport"));

			return sport;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return null;

		}

	}
	//GIT
	public boolean updateSport(Sport sportToUpdate) {

		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present

		if (sportToUpdate.getIdsport() == 0)

			return false;
 

			try {

				// Fill the userToUpdate object

			
			
				

				// Update the user

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);

				preparedStatement.setString(1, sportToUpdate.getNome());
				preparedStatement.setInt(2, sportToUpdate.getTipo());
				preparedStatement.setInt(3, sportToUpdate.getDurata());
				preparedStatement.setInt(4, sportToUpdate.getIdsport());
				
				int a = preparedStatement.executeUpdate();

				if (a > 0)

					return true;

				else

					return false;

			} catch (SQLException e) {

				return false;
		
			}
	}
		
	

	public boolean deleteSport(Sport	sport) {
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


	}

