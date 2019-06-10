package it.contrader.dao;

import java.sql.*;


import java.util.ArrayList;

import java.util.List;

import java.util.Vector;

import it.contrader.controller.GestoreEccezioni;

import it.contrader.main.ConnectionSingleton;

import it.contrader.model.Meal;
import it.contrader.model.User;

public class MealDAO {

	private final String QUERY_ALL = "select * from meal";

	private final String QUERY_INSERT = "insert into meal (piatto,kcal) values (?,?)";

	private final String QUERY_READ = "select * from meal where idpiatti=?";

	private final String QUERY_UPDATE = "UPDATE meal SET piatto=?,kcal=?  WHERE idpiatti=?";

	private final String QUERY_DELETE = "delete from meal where idpiatti=?";

	public MealDAO() {

	}

	public List<Meal> getAllMeal() {

		List<Meal> mealList = new ArrayList<>();

		Connection connection = ConnectionSingleton.getInstance();

		try {

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(QUERY_ALL);

			Meal meal ;

			while (resultSet.next()) {

				int idpiatto = resultSet.getInt("idpiatti");

				String piatto = resultSet.getString("piatto");

				int kcal = resultSet.getInt("kcal");

				

				meal = new Meal(piatto,kcal);

				meal.setIdpiatti(idpiatto);

				mealList.add(meal);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return mealList;

	}
	

	public boolean insertMeal(Meal meal) {

		Connection connection = ConnectionSingleton.getInstance();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);

			preparedStatement.setString(1, meal.getPiatto());
			preparedStatement.setInt(2, meal.getKcal());


			preparedStatement.execute();

			return true;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return false;

		}

	}

	public Meal readMeal(int idpiatti) {

		Connection connection = ConnectionSingleton.getInstance();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);

			preparedStatement.setInt(1, idpiatti);

			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();

			int kcal;
			String piatto;

			piatto = resultSet.getString("piatto");
			kcal = resultSet.getInt("kcal");

			Meal meal = new Meal(piatto,kcal);

			meal.setIdpiatti(resultSet.getInt("idpiatti"));

			return meal;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return null;

		}
	}

	
		public boolean updateMeal(Meal  mealToUpdate) {

			Connection connection = ConnectionSingleton.getInstance();

			// Check if id is present

			if (mealToUpdate.getIdpiatti() == 0)

				return false;

			Meal mealRead = readMeal(mealToUpdate.getIdpiatti());

			if (!mealRead.equals(mealToUpdate)) {

				try {

					// Fill the userToUpdate object

					if (mealToUpdate.getPiatto() == null || mealToUpdate.getPiatto().equals("")) {

						mealToUpdate.setPiatto(mealRead.getPiatto());
					}
						if (mealToUpdate.getKcal() == 0 || mealToUpdate.getKcal()>0) {

							mealToUpdate.setKcal(mealRead.getKcal());

					}


					// Update the user

					PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);

					preparedStatement.setString(1, mealToUpdate.getPiatto());
					preparedStatement.setInt(2, mealToUpdate.getKcal());
					preparedStatement.setInt(3, mealToUpdate.getIdpiatti());

					int a = preparedStatement.executeUpdate();

					if (a > 0)

						return true;

					else

						return false;

					}catch (SQLException e) {

					return false;

				}

			}

			return false;


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