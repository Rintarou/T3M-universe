import { ElementService } from './../../services/element.service';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-element',
  templateUrl: './element.component.html',
  styleUrls: ['./element.component.css'],
})
export class ElementComponent implements OnInit {
  @Input('id') id: number = -1;

  data: any = {};

  constructor(private elementService: ElementService) {}

  get universe_id() {
    return Number(sessionStorage.getItem('universe_id'));
  }

  reload(id: number) {
    this.id = id;
    this.load();
  }

  ngOnInit(): void {
    this.load();
  }

  load(): void {
    this.elementService.byId(this.id, this.universe_id).subscribe({
      next: (d) => (this.data = d),
      error: (e) => console.log(e),
      complete: () => console.info('element retrieved'),
    });
  }
}
