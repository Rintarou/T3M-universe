import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardUniverseComponent } from './dashboard-universe.component';

describe('DashboardUniverseComponent', () => {
  let component: DashboardUniverseComponent;
  let fixture: ComponentFixture<DashboardUniverseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardUniverseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardUniverseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
