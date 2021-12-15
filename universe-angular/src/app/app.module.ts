import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ElementComponent } from './components/element/element.component';
import { RouterModule } from '@angular/router';

import { routes } from './routes';
import { ElementEditorComponent } from './components/element-editor/element-editor.component';
import { LoginComponent } from './components/login/login.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { HomeComponent } from './components/home/home.component';
import { DashboardElementComponent } from './components/dashboard-element/dashboard-element.component';
import { UniverseEditorComponent } from './components/universe-editor/universe-editor.component';
import { DashboardUniverseComponent } from './components/dashboard-universe/dashboard-universe.component';
import { UniverseComponent } from './components/universe/universe.component';

@NgModule({
  declarations: [
    AppComponent,
    ElementComponent,
    ElementEditorComponent,
    LoginComponent,
    InscriptionComponent,
    HomeComponent,
    DashboardElementComponent,
    UniverseEditorComponent,
    DashboardUniverseComponent,
    UniverseComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
