import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HinduLunarComponent } from './hindu-lunar.component';

describe('HinduLunarComponent', () => {
  let component: HinduLunarComponent;
  let fixture: ComponentFixture<HinduLunarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HinduLunarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HinduLunarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
