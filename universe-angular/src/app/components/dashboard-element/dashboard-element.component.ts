import { ElementService } from './../../services/element.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard-element',
  templateUrl: './dashboard-element.component.html',
  styleUrls: ['./dashboard-element.component.css']
})
export class DashboardElementComponent implements OnInit {
  
  data :any = [];

  constructor( private elementService :ElementService) { }

  ngOnInit(): void {
    this.elementService.all().subscribe({
      next: ( d ) => this.data = d,
      error: ( e ) =>  console.log( e ),
      complete: () =>  console.info('element retrieved'),
    });
  }

}
