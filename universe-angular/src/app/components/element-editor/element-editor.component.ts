import { ElementService } from '../../services/element.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-element-editor',
  templateUrl: './element-editor.component.html',
  styleUrls: ['./element-editor.component.css'],
})
export class ElementEditorComponent implements OnInit {
  element: any = {};

  image: ImageSnippet | any;

  constructor(private elementService: ElementService, private router: Router) {}

  get universe_id() {
    return Number(sessionStorage.getItem('universe_id'));
  }

  ngOnInit(): void {}

  public save() {
    this.elementService
      .insert(this.element, this.universe_id)
      .subscribe((res) => {
        this.elementService
          .addImage(res.id, this.image.file, this.universe_id)
          .subscribe(console.log);
      });
    this.router.navigate(['/dashboard']);
  }

  processFile(imageInput: any) {
    const file: File = imageInput.files[0];
    const reader = new FileReader();

    reader.addEventListener('load', (event: any) => {
      this.image = new ImageSnippet(event.target.result, file);
    });

    reader.readAsDataURL(file);
  }
}

class ImageSnippet {
  constructor(public src: string, public file: File) {}
}
