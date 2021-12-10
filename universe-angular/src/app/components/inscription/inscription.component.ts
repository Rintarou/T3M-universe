import { User } from './../../model/user';
import { Observable, timer } from 'rxjs';
import { debounceTime, map, distinctUntilChanged, delay } from 'rxjs/operators';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form: FormGroup;

  constructor(private userService: UserService, private fb: FormBuilder) {
    this.form = new FormGroup({
      login: new FormControl('', [Validators.required], this.checkLogin()),
      passwordGroup: new FormGroup(
        {
          password: new FormControl('', [
            Validators.required,
            Validators.pattern(
              /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])([a-zA-Z0-9$@#_-]{5,25})$/
            ),
          ]),
          confirm: new FormControl(''),
        },
        this.checkNotEquals
      ),
    });
    //this.form.controls['login'].updateOn = 'blur';
  }

  ngOnInit(): void {}

  save() {
    let user: User = new User(
      undefined,
      this.form.controls['login'].value,
      this.form.get('passwordGroup.password')!.value
    );
    this.userService.insert(user).subscribe((u) => {
      console.log(u);
    });
  }

  checkLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.userService.checkLogin(control.value).pipe(
        debounceTime(1000),
        distinctUntilChanged(),
        map((res: boolean) => {
          return res ? { loginUsed: true } : null;
        })
      );
    };
  }

  checkNotEquals(group: AbstractControl): ValidationErrors | null {
    let formGroup: FormGroup = group as FormGroup;
    if (formGroup.controls['password'].errors) {
      return null;
    }
    return formGroup.controls['password'].value !=
      formGroup.controls['confirm'].value
      ? { checkNotEquals: true }
      : null;
  }
}
