import { ActivatedRoute } from '@angular/router';
import { Component, Input, OnInit } from '@angular/core';
import { ElementService } from 'src/app/services/element.service';

@Component({
  selector: 'app-element-view',
  templateUrl: './element-view.component.html',
  styleUrls: ['./element-view.component.css']
})
export class ElementViewComponent implements OnInit {
  
  @Input('id') id: number | string | null = -1;

  data: any = {} ;
  relatives: any = [];

  constructor( private elementService: ElementService, private activatedRoute :ActivatedRoute ) {}

  get universe_id() {
    return Number(sessionStorage.getItem('universe_id'));
  }

  reload( id: number ) {
    this.id = id;
    this.load();
  }

  ngOnInit(): void {
    let params = this.activatedRoute.paramMap;
    params.subscribe( ( res )=> { 
      this.relatives = [];
      this.id = res.get('id'); 
      this.load();
    });
  }

  load(): void {
    this.elementService.byId(this.id, this.universe_id).subscribe({
      next: (d) => (this.data = d),
      error: (e) => console.log(e),
      complete: () => console.info('element retrieved'),
    });

    this.elementService.children(this.id, this.universe_id).subscribe({
      next: (d) => ( this.relatives = this.relatives.concat( d ) ),
      error: (e) => console.log(e),
      complete: () => console.info('element retrieved'),
    });
    
    this.elementService.parents(this.id, this.universe_id).subscribe({
      next: (d) => ( this.relatives = this.relatives.concat( d ) ),
      error: (e) => console.log(e),
      complete: () => console.info('element retrieved'),
    });
  }
}
