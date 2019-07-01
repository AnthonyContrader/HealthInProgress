import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { ParametersComponent } from './parameters/parameters.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { DevicesComponent } from './devices/devices.component';
import { MealComponent } from './meals/meals.component';
import { IngredientsComponent } from './ingredients/ingredients.component';
import { SportsComponent } from './sports/sports.component';



/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'admin-dashboard', component: AdminLayoutComponent, children:[
    { path: '', component: AdminDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'parameters', component: ParametersComponent},
    { path: 'devices', component: DevicesComponent},
    { path: 'meals', component: MealComponent},
    { path: 'sports', component: SportsComponent},
    { path: 'ingredients', component: IngredientsComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }