import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HinduLunarMoonphaseComponent } from './hindu-lunar-moonphase.component';

describe('HinduLunarMoonphaseComponent', () => {
  let component: HinduLunarMoonphaseComponent;
  let fixture: ComponentFixture<HinduLunarMoonphaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HinduLunarMoonphaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HinduLunarMoonphaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
