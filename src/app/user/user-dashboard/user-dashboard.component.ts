import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { ParameterDTO } from 'src/dto/parameterdto';
import { DeviceDTO } from 'src/dto/devicedto';
import { ParameterService } from 'src/service/parameter.service';


/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

 
  parameters: ParameterDTO[];
  parametertoinsert: ParameterDTO = new ParameterDTO();

  constructor(private service: ParameterService) { }

  ngOnInit() {
    this.getParameters();
  }

  getParameters() {
    this.service.getAll().subscribe(parameters => this.parameters = parameters);
  }

  delete(parameter: ParameterDTO) {
    this.service.delete(parameter.id).subscribe(() => this.getParameters());
  }

  update(parameter: ParameterDTO) {
    this.service.update(parameter).subscribe(() => this.getParameters());
  }

  insert(parameter: ParameterDTO) {
    this.service.insert(parameter).subscribe(() => this.getParameters());
  }

  clear(){
    this.parametertoinsert = new ParameterDTO();
  }
  calc(sesso:string, altezza: number, peso: number, eta: number ){
    if (sesso === 'Maschio') {this.parametertoinsert.totkcal = (66.5+(13.8*peso)+(5*altezza)-(6.5*eta));}
    else {this.parametertoinsert.totkcal = (655.1+(9.6*peso)+(1.9*altezza-(4.7*eta)));}
 
   }
}

