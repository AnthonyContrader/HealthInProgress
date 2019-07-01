import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { MealDTO } from 'src/dto/mealdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SportDTO } from 'src/dto/sportdto';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate i metodi ereditati dall'Abstract(in mirror con il backend).
 * 
 * @author PattyGè
 * 
 * @see AbstractService
 */
@Injectable({
    providedIn: 'root'
})
export class SportService extends AbstractService<SportDTO>{
   
    constructor(http: HttpClient) {
        super(http);
        this.type = 'sport';
    }

}