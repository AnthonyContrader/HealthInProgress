import { Component, OnInit } from '@angular/core';
import { MealService } from 'src/service/meal.service';
import { MealDTO } from 'src/dto/mealdto';

@Component({
  selector: 'app-meals',
  templateUrl: './meals.component.html',
  styleUrls: ['./meals.component.css']
})
export class MealComponent implements OnInit {

  meals: MealDTO[];
  mealtoinsert: MealDTO = new MealDTO();

  constructor(private service: MealService) { }

  ngOnInit() {
    this.getMeal();
  }

  getMeal() {
    this.service.getAll().subscribe(meal => this.meals = meal);
  }

  delete(meal: MealDTO) {
    this.service.delete(meal.id).subscribe(() => this.getMeal());
  }

  update(meal: MealDTO) {
    this.service.update(meal).subscribe(() => this.getMeal());
  }

  insert(meal: MealDTO) {
    this.service.insert(meal).subscribe(() => this.getMeal());
  }

  clear(){
    this.mealtoinsert = new MealDTO();
  }
}