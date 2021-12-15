import { RelationService } from './../../services/relation.service';
import { ElementService } from 'src/app/services/element.service';
import { Component, OnInit, Input } from '@angular/core';
import { iif } from 'rxjs';
import { resolveSanitizationFn } from '@angular/compiler/src/render3/view/template';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-relation-editor',
  templateUrl: './relation-editor.component.html',
  styleUrls: ['./relation-editor.component.css']
})
export class RelationEditorComponent implements OnInit {

  @Input('parent') parent :any; 

  relation :any = {
    id: {
      parent: {},
      child: {},
    },
    natures: [],
  };

  child :string = ''
  nature :string = '';

  elements :any;
  options :any;

  constructor(private elementService :ElementService, private relationService :RelationService, private activatedRoute :ActivatedRoute ) { }

  ngOnInit(): void {
    let params = this.activatedRoute.paramMap;
    params.subscribe( ( res )=> { 
      this.relation.id.parent.id = res.get('id'); 
    });
    
  }

  public naming() {
    if( this.nature.length > 0)
    this.relationService.byName( this.nature ).subscribe(
      ( d ) => this.options = d
    )
  }

  get universe_id() {
    return Number(sessionStorage.getItem('universe_id'));
  }
  
  public target() {
    if( this.child.length > 0)
    this.elementService.byName( this.child, this.universe_id  ).subscribe(
      ( d ) => { this.elements = d; console.log( d ); }
    )
  }

  public save() {
    if( this.child.length > 0 && this.nature.length > 0 ) {
      this.relation.id.child.id = this.elements[0].id;
      this.relation.natures.push( this.nature );
      console.log( this.relation );
      this.relationService.save( this.relation ).subscribe(console.log);
    }
  }

}
