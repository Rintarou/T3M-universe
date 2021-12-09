import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login: string = '';
  password: string = '';
  showMessage = false;
  message = '';

  constructor(
    private authenticationService: AuthenticationService,
    private router: Router,
    private activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedroute.queryParams.subscribe((params) => {
      if (!!params['error']) {
        if (params['error']) {
          this.message = 'authentification requise';
          this.showMessage = true;
        }
      }
    });
  }

  check() {
    this.authenticationService.auth(this.login, this.password).subscribe(
      (userWithUniverse) => {
        // Mettre la liste des univers dans la session
        console.log(userWithUniverse);
        this.showMessage = false;
        sessionStorage.setItem('token', btoa(this.login + ':' + this.password));
        sessionStorage.setItem('login', this.login);
      },
      (error) => {
        this.message = "erreur d'authentification";
        this.showMessage = true;
      }
    );
  }
}
