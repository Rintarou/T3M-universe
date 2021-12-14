import { InscriptionComponent } from './components/inscription/inscription.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ElementEditorComponent } from './components/element-editor/element-editor.component';
import { ElementComponent } from './components/element/element.component';
import { AppComponent } from './app.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'worlds', component: ElementEditorComponent },
  { path: 'dashboard', component: ElementComponent },
  { path: 'info', component: ElementEditorComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
