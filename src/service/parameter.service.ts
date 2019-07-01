import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ParameterDTO } from 'src/dto/parameterdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class ParameterService extends AbstractService<ParameterDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'parameter';
  }

  

}
