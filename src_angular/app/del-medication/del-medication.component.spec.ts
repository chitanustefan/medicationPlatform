import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DelMedicationComponent } from './del-medication.component';

describe('DelMedicationComponent', () => {
  let component: DelMedicationComponent;
  let fixture: ComponentFixture<DelMedicationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DelMedicationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DelMedicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
