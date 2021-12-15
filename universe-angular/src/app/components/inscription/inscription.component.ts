import { User } from './../../model/user';
import { Observable, timer, of, catchError } from 'rxjs';
import {
  debounceTime,
  map,
  distinctUntilChanged,
  delay,
  first,
  switchMap,
} from 'rxjs/operators';
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
import { Router } from '@angular/router';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form: FormGroup;

  constructor(
    private userService: UserService,
    private fb: FormBuilder,
    private router: Router
  ) {
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
    this.form.controls['login'].valueChanges.subscribe();
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
    this.router.navigate(['/login']);
  }

  checkLogin(): AsyncValidatorFn {
    return (control) =>
      control.valueChanges.pipe(
        debounceTime(1000),
        distinctUntilChanged(),
        switchMap((value) => this.userService.checkLogin(value)),
        map((unique: boolean) => (unique ? { loginUsed: true } : null)),
        first()
      ); // important to make observable finite
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

  loginErrorMessage() {
    if (this.form.get('login')!.hasError('required')) {
      return 'login required';
    }
    return 'login already used';
  }

  passwordErrorMessage() {
    if (this.form.get('passwordGroup.password')!.hasError('required')) {
      return 'password required';
    } else if (this.form.get('passwordGroup.password')!.hasError('pattern')) {
      return 'the password must contain between 5 and 25 characters, including a capital letter and a number';
    }
    return 'passwords are not the same';
  }
}
