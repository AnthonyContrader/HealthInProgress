import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { ParameterDTO } from 'src/dto/parameterdto';
import { DeviceDTO } from 'src/dto/devicedto';
import { MealDTO } from 'src/dto/mealdto';
import { IngredientDTO } from 'src/dto/ingredientdto';
import { SportDTO } from 'src/dto/sportdto';


/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  user: UserDTO;
  parameter: ParameterDTO;
  device: DeviceDTO;
  meal: MealDTO;
  ingredient: IngredientDTO;
  sport: SportDTO;
  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.parameter = JSON.parse(localStorage.getItem('currentParameter'));
    this.device = JSON.parse(localStorage.getItem('currentDevice'));
    this.meal = JSON.parse(localStorage.getItem('currentMeal'));
    this.ingredient = JSON.parse(localStorage.getItem('currentIngredient'));
    this.sport = JSON.parse(localStorage.getItem('currentSport'));
  }

}
