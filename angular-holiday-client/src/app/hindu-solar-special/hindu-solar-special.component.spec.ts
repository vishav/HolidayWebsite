import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HinduSolarSpecialComponent } from './hindu-solar-special.component';

describe('HinduSolarSpecialComponent', () => {
  let component: HinduSolarSpecialComponent;
  let fixture: ComponentFixture<HinduSolarSpecialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HinduSolarSpecialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HinduSolarSpecialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
