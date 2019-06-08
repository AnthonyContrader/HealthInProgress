package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;

import it.contrader.controller.GestoreEccezioni;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Meal;
import it.contrader.model.User;

public class MealDAO {

	private final String QUERY_ALL = "select * from Meal";

	private final String QUERY_INSERT = "insert into meal (Kcal,piatto) values (?,?)";

	private final String QUERY_READ = "select * from Meal where Idpiatti=?";

	private final String QUERY_UPDATE = "UPDATE Kcal=?,piatto=?,WHERE Idpiatti=?";

	private final String QUERY_DELETE = "delete from user where Idpiatti=?";

	public MealDAO() {

	}

	public List<Meal> getAllMeal() {

		List<Meal> MealList = new ArrayList<>();

		Connection connection = ConnectionSingleton.getInstance();

		try {

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(QUERY_ALL);

			Meal meal;

			while (resultSet.next()) {

				int Id = resultSet.getInt("Idpiatti");

				int kcal = resultSet.getInt("Kcal");
				String piatto = resultSet.getString("piatto");

				meal = new Meal(Id, kcal, piatto);
				meal.setIdpiatti(Id);

				MealList.add(meal);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return MealList;

	}

	public boolean insertMeal(Meal meal) {

		Connection connection = ConnectionSingleton.getInstance();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);

			preparedStatement.setInt(1, meal.getKcal());
			preparedStatement.setString(2, meal.getPiatto());

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return false;

		}

	}

	public Meal readMeal(int Idpiatti) {

		Connection connection = ConnectionSingleton.getInstance();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);

			preparedStatement.setInt(1, Idpiatti);

			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();
			
			int idpiatti;
            int Kcal;
			String piatto ;
			
			idpiatti=resultSet.getInt("Idpiatti");
			Kcal = resultSet.getInt("Kcal");
			piatto = resultSet.getString("piatto");
		
			Meal meal  = new Meal(idpiatti,Kcal,piatto);

			meal.setIdpiatti(idpiatti);

			return meal;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return null;

		}

	}

	public boolean updatemeal(Meal mealtoUpdate) {

		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present

		if (mealtoUpdate.getIdpiatti() == 0)

			return false;

		// Update the user
		try {

			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);

			preparedStatement.setInt(1, mealtoUpdate.getKcal());
			preparedStatement.setString(2, mealtoUpdate.getPiatto());
			int a = preparedStatement.executeUpdate();


			if (a > 0)

				return true;

			else

				return false;

		} catch (SQLException e) {

			return false;

		}

	}

	public boolean deleteMeal(Integer id) {

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