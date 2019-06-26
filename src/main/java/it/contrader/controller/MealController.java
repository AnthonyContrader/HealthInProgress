package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.MealDTO;
import it.contrader.service.MealService;



@RestController
@RequestMapping("/meal")
@CrossOrigin(origins = "http://localhost:4200")
public class MealController extends AbstractController<MealDTO>{
	
	
}
