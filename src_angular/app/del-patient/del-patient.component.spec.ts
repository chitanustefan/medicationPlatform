import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DelPatientComponent } from './del-patient.component';

describe('DelPatientComponent', () => {
  let component: DelPatientComponent;
  let fixture: ComponentFixture<DelPatientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DelPatientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DelPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
