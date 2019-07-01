

import { Component, OnInit } from '@angular/core';
import { ParameterDTO } from 'src/dto/parameterdto';
import { ParameterService } from 'src/service/parameter.service';
import { UserDTO } from 'src/dto/userdto';
import { from } from 'rxjs';

@Component({
  selector: 'app-parameters',
  templateUrl: './parameters.component.html',
  styleUrls: ['./parameters.component.css']
})
export class ParametersComponent implements OnInit {

  parameters: ParameterDTO[];
  parametertoinsert: ParameterDTO = new ParameterDTO();
  user: UserDTO;
  constructor(private service: ParameterService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
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

  
  
}
