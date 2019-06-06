package it.contrader.service;

import java.util.List;

import it.contrader.dao.MealDAO;
import it.contrader.model.Meal;
 

public class MealService {
	
	private MealDAO mealDAO;
	
	public MealService() {
		this.mealDAO = new MealDAO();
	}

	public List<Meal> getAllMeal() {
		return this.mealDAO.getAllMeal();
	}
	
	public boolean insertMeal(Meal meal) {
		return this.mealDAO.insertMeal (meal);
	
	}

	public Meal readMeal(int Idpiatti) {
		return this.mealDAO.readMeal(Idpiatti);

	}
	
	public boolean updateMeal(Meal meal) {
		return this.mealDAO.updatemeal(meal);
	}
	
	public boolean deleteMeal(int meal) {
		return this.mealDAO.deleteMeal(meal);

	
	}
	
	
}