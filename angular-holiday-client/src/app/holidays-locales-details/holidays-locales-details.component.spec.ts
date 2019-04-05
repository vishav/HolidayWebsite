import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HolidaysLocalesDetailsComponent } from './holidays-locales-details.component';

describe('HolidaysLocalesDetailsComponent', () => {
  let component: HolidaysLocalesDetailsComponent;
  let fixture: ComponentFixture<HolidaysLocalesDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HolidaysLocalesDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HolidaysLocalesDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
