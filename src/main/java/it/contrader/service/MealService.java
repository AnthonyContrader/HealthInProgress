package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterMeal;
import it.contrader.dao.MealDAO;
import it.contrader.dto.MealDTO;
import it.contrader.model.Meal;

public class MealService {
	
	private MealDAO mealDAO;
	
	public MealService() {
		this.mealDAO = new MealDAO();
	}

	public List<Meal> getAllMeal() {
		return this.mealDAO.getAllMeal();
	}
	
	public boolean insertMeal( MealDTO mealDTO) {
		return this.mealDAO.insertMeal(ConverterMeal.toEntity(mealDTO));
	
	}

	public MealDTO readMeal(int idmeal) {
		return ConverterMeal.toDTO(this.mealDAO.readMeal(idmeal));

	}
	
	public boolean updateMeal(MealDTO mealDTO) {
		return this.mealDAO.updateMeal(ConverterMeal.toEntity(mealDTO));
	}
	
	public boolean deleteMeal(int idmeal) {
		return this.mealDAO.deleteMeal(idmeal);

	
	}
	
	
}