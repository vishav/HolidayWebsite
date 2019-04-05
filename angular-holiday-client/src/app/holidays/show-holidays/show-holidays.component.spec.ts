import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowHolidaysComponent } from './show-holidays.component';

describe('ShowHolidaysComponent', () => {
  let component: ShowHolidaysComponent;
  let fixture: ComponentFixture<ShowHolidaysComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowHolidaysComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowHolidaysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
