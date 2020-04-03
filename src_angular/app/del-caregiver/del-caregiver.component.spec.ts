import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DelCaregiverComponent } from './del-caregiver.component';

describe('DelCaregiverComponent', () => {
  let component: DelCaregiverComponent;
  let fixture: ComponentFixture<DelCaregiverComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DelCaregiverComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DelCaregiverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
