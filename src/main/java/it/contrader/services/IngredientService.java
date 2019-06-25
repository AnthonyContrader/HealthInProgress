 package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterIngredient;
import it.contrader.converter.ConverterMeal;
import it.contrader.converter.ConverterParameter;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.IngredientRepository;
import it.contrader.dto.IngredientDTO;
import it.contrader.dto.MealDTO;
import it.contrader.dto.ParameterDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Ingredient;
import it.contrader.model.Meal;
import it.contrader.model.Parameter;


@Service
public class IngredientService {

	private final IngredientRepository ingredientRepository;
	
	@Autowired

	public IngredientService(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}
	
	public List<IngredientDTO> getListaIngredientDTO(){
		return ConverterIngredient.toListDTO((List<Ingredient>) ingredientRepository.findAll());
		
	}
	
	public IngredientDTO getIngredientDTOById(Integer id) {
		return ConverterIngredient.toDTO(ingredientRepository.findById(id).get());
	}

	
	public boolean insertIngredient(IngredientDTO ingredientDTO) {
		return ingredientRepository.save(ConverterIngredient.toEntity(ingredientDTO)) != null;
	}
	
	public boolean updateIngredient(IngredientDTO ingredientDTO) {
		return ingredientRepository.save(ConverterIngredient.toEntity(ingredientDTO)) != null;
	}
	
	public void deleteIngredientById(Integer id) {
		ingredientRepository.deleteById(id);
	}
	
public List<IngredientDTO> findIngredientDTOByMeal( MealDTO mealDTO) {
		
		final List<Ingredient> listIngredient = ingredientRepository.findAllByMeal(ConverterMeal.toEntity(mealDTO));
		final List<IngredientDTO> listIngredientDTO = new ArrayList<>();
		listIngredient.forEach(i -> listIngredientDTO.add(ConverterIngredient.toDTO(i)));
		return listIngredientDTO;
	}
}