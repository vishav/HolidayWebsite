import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HebrewSpecialComponent } from './hebrew-special.component';

describe('HebrewSpecialComponent', () => {
  let component: HebrewSpecialComponent;
  let fixture: ComponentFixture<HebrewSpecialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HebrewSpecialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HebrewSpecialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
