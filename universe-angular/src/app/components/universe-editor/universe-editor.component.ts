import { Universe } from './../../model/universe';
import { UniverseService } from './../../services/universe.service';
import { Component, OnInit } from '@angular/core';
import {
  AsyncValidatorFn,
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import {
  debounceTime,
  distinctUntilChanged,
  first,
  map,
  switchMap,
} from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-universe-editor',
  templateUrl: './universe-editor.component.html',
  styleUrls: ['./universe-editor.component.css'],
})
export class UniverseEditorComponent implements OnInit {
  form: FormGroup;

  image: ImageSnippet | any;

  constructor(
    private universeService: UniverseService,
    private router: Router
  ) {
    this.form = new FormGroup({
      name: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit(): void {}

  save() {
    let universe: Universe = new Universe(
      undefined,
      this.form.controls['name'].value
    );
    this.universeService.insert(universe).subscribe((res) => {
      this.universeService
        .addImage(res.id, this.image.file)
        .subscribe(console.log);
    });
    this.router.navigate(['/home']);
  }

  nameErrorMessage() {
    if (this.form.get('name')!.hasError('required')) {
      return 'name required';
    }
    return '';
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
