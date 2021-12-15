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

@NgModule({
  declarations: [
    AppComponent,
    ElementComponent,
    ElementEditorComponent,
    LoginComponent,
    InscriptionComponent,
    HomeComponent,
    DashboardElementComponent,
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
