import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isParameterCollapsed = false;
  isDeviceCollapsed = false;
  isMealCollapsed = false;
  isIngredientCollapsed = false;
  isSportCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }
  ingredientscollapse() {
    if (this.isIngredientCollapsed === false) {
      this.isIngredientCollapsed = true;
    } else { this.isIngredientCollapsed = false; }
  }
  devicescollapse() {
    if (this.isDeviceCollapsed === false) {
      this.isDeviceCollapsed = true;
    } else { this.isDeviceCollapsed = false; }
  }
  parameterscollapse() {
    if (this.isParameterCollapsed === false) {
      this.isParameterCollapsed = true;
    } else { this.isParameterCollapsed = false; }
  }
  sportscollapse() {
    if (this.isSportCollapsed === false) {
      this.isSportCollapsed = true;
    } else { this.isSportCollapsed = false; }
  }
  mealscollapse() {
    if (this.isMealCollapsed === false) {
      this.isMealCollapsed = true;
    } else { this.isMealCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
