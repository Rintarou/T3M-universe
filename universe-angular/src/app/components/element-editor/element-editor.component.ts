import { ElementService } from '../../services/element.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-element-editor',
  templateUrl: './element-editor.component.html',
  styleUrls: ['./element-editor.component.css']
})
export class ElementEditorComponent implements OnInit {

  element :any = {}

  image :ImageSnippet | any;

  constructor( private elementService :ElementService ) {}

  ngOnInit(): void {
  }

  public save() {
    this.elementService.insert( this.element ).subscribe(
      ( res ) => { this.elementService.addImage( res.id, this.image.file ).subscribe( console.log ); }
    );
  }

  processFile( imageInput :any ) {
    const file: File = imageInput.files[0];
    const reader = new FileReader();

    reader.addEventListener('load', (event :any) => {

      this.image = new ImageSnippet( event.target.result, file );

    });

    reader.readAsDataURL( file );
  }

}

class ImageSnippet {
  constructor(public src: string, public file: File) {}
}
