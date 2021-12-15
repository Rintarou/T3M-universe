import { UniverseService } from './../../services/universe.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard-universe',
  templateUrl: './dashboard-universe.component.html',
  styleUrls: ['./dashboard-universe.component.css'],
})
export class DashboardUniverseComponent implements OnInit {
  data: any = [];

  constructor(private universeService: UniverseService) {}

  ngOnInit(): void {
    this.universeService.all().subscribe({
      next: (d) => (this.data = d),
      error: (e) => console.log(e),
      complete: () => console.info('universe retrieved'),
    });
  }
}
