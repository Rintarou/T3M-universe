import { ElementService } from '../../services/element.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-element-editor',
  templateUrl: './element-editor.component.html',
  styleUrls: ['./element-editor.component.css']
})
export class ElementEditorComponent implements OnInit {

  element :any = {}

  constructor( private elementService :ElementService) {}

  ngOnInit(): void {
  }

  public save() {
    this.elementService.insert( this.element );
  }

}
