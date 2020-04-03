import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedplanEditComponent } from './medplan-edit.component';

describe('MedplanEditComponent', () => {
  let component: MedplanEditComponent;
  let fixture: ComponentFixture<MedplanEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedplanEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedplanEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
