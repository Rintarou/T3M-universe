import { UniverseEditorComponent } from './components/universe-editor/universe-editor.component';
import { DashboardUniverseComponent } from './components/dashboard-universe/dashboard-universe.component';
import { DashboardElementComponent } from './components/dashboard-element/dashboard-element.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ElementEditorComponent } from './components/element-editor/element-editor.component';
import { ElementComponent } from './components/element/element.component';
import { AppComponent } from './app.component';
import { Routes } from '@angular/router';
import { UniverseComponent } from './components/universe/universe.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'universeEditor', component: UniverseEditorComponent },
  { path: 'universes', component: DashboardUniverseComponent },
  { path: 'worlds', component: ElementEditorComponent },
  { path: 'dashboard', component: DashboardElementComponent },
  { path: 'info', component: ElementEditorComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
