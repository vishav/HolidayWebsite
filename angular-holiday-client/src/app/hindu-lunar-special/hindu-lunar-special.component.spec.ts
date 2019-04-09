import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HinduLunarSpecialComponent } from './hindu-lunar-special.component';

describe('HinduLunarSpecialComponent', () => {
  let component: HinduLunarSpecialComponent;
  let fixture: ComponentFixture<HinduLunarSpecialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HinduLunarSpecialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HinduLunarSpecialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
