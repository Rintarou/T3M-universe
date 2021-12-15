import { ElementService } from './../../services/element.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard-element',
  templateUrl: './dashboard-element.component.html',
  styleUrls: ['./dashboard-element.component.css'],
})
export class DashboardElementComponent implements OnInit {
  data: any = [];

  constructor(private elementService: ElementService, private router: Router) {}

  get universe_id() {
    return Number(sessionStorage.getItem('universe_id'));
  }

  ngOnInit(): void {
    this.elementService.all(this.universe_id).subscribe({
      next: (d) => (this.data = d),
      error: (e) => console.log(e),
      complete: () => console.info('element retrieved'),
    });
  }

  newElem() {
    this.router.navigate(['/info']);
  }
}
