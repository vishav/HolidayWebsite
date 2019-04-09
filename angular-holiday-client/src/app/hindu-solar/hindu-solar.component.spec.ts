import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HinduSolarComponent } from './hindu-solar.component';

describe('HinduSolarComponent', () => {
  let component: HinduSolarComponent;
  let fixture: ComponentFixture<HinduSolarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HinduSolarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HinduSolarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
