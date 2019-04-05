import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HolidayNotesComponent } from './holiday-notes.component';

describe('HolidayNotesComponent', () => {
  let component: HolidayNotesComponent;
  let fixture: ComponentFixture<HolidayNotesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HolidayNotesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HolidayNotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
