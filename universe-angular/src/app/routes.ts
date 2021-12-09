import { ElementEditorComponent } from './components/element-editor/element-editor.component';
import { ElementComponent } from './components/element/element.component'; 
import { AppComponent } from './app.component';
import { Routes } from '@angular/router';

export const routes :Routes = [
    { path: 'home', component: ElementComponent },
    { path: 'worlds', component: ElementEditorComponent },
    { path: 'dashboard', component: ElementComponent },
    { path: 'info', component: ElementEditorComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' },
];