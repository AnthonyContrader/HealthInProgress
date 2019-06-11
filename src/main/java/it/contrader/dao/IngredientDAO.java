package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;

import java.util.Vector;

import it.contrader.controller.GestoreEccezioni;

import it.contrader.main.ConnectionSingleton;

import it.contrader.model.Ingredient;

public class IngredientDAO {

	private final String QUERY_ALL = "select * from ingredient";

	private final String QUERY_INSERT = "insert into ingredient (nome) values (?)";

	private final String QUERY_READ = "select * from ingredient where idingredient=?";

	private final String QUERY_UPDATE = "UPDATE ingredient set Nome=? WHERE idingredient=?";

	private final String QUERY_DELETE = "delete from ingredient where idingredient=?";

	public IngredientDAO() {

	}

	public List<Ingredient> getAllIngredient() {

		List<Ingredient> ingredientList = new ArrayList<>();

		Connection connection = ConnectionSingleton.getInstance();

		try {

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(QUERY_ALL);

			Ingredient ingredient;

			while (resultSet.next()) {

				int idingredient = resultSet.getInt("idingredient");

				String nome = resultSet.getString("nome");

				

				ingredient= new Ingredient( nome);

				ingredient.setIdingredient(idingredient);;

				ingredientList.add(ingredient);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return ingredientList;

	}

	public boolean insertIngredient(Ingredient ingredient) {

		Connection connection = ConnectionSingleton.getInstance();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);

			preparedStatement.setString(1, ingredient.getNome());
			

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return false;

		}

	}

	public Ingredient readIngredient(int idingredient) {

		Connection connection = ConnectionSingleton.getInstance();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);

			preparedStatement.setInt(1, idingredient);

			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();

			String nome;

			nome = resultSet.getString("nome");
	

			Ingredient ingredient = new Ingredient(nome);

			ingredient.setIdingredient(resultSet.getInt("idingredient"));

			return ingredient;

		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return null;

		}

	}

	public boolean updateIngredient(Ingredient ingredientToUpdate) {

		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present

		if (ingredientToUpdate.getIdingredient() == 0)

			return false;

		Ingredient ingredientRead = readIngredient(ingredientToUpdate.getIdingredient());

		if (!ingredientRead.equals(ingredientToUpdate)) {

			try {

				// Fill the userToUpdate object

				if (ingredientToUpdate.getNome() == null || ingredientToUpdate.getNome().equals("")) {

					ingredientToUpdate.setNome(ingredientRead.getNome());

				}

			

				// Update the user

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);

				preparedStatement.setString(1, ingredientToUpdate.getNome());

				preparedStatement.setInt(2, ingredientToUpdate.getIdingredient());

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

	public boolean deleteIngredient(Integer id) {

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