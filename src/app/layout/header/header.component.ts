import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { SportDTO } from 'src/dto/sportdto';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  user: UserDTO = new UserDTO;


  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
 
  }

}
