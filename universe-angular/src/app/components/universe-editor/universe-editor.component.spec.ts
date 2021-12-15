import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UniverseEditorComponent } from './universe-editor.component';

describe('UniverseEditorComponent', () => {
  let component: UniverseEditorComponent;
  let fixture: ComponentFixture<UniverseEditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UniverseEditorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UniverseEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
