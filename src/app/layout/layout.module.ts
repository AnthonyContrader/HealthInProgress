
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';

import { HeaderComponent } from './header/header.component';
import { RouterModule } from '@angular/router';
import { UserLayoutComponent } from './admin-layout/user-layout.component';
import { UserDashboardComponent } from '../user/user-dashboard/user-dashboard.component';

import { AdminMenuComponent } from './admin-layout/admin-menu/admin-menu.component';

/**
 * Modulo di layout. Viene caricato nel rputer outlet padre e poi 
 * non viene più ricaricato. Quando clicchiamo su un link ricarichiamo solo l'outlet
 * che sta dentro AdminLayoutComponent
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 */
@NgModule({
  declarations: [AdminLayoutComponent,UserLayoutComponent,AdminMenuComponent, HeaderComponent],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class LayoutModule { }