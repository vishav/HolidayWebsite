import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OldHinduLunarSpecialComponent } from './old-hindu-lunar-special.component';

describe('OldHinduLunarSpecialComponent', () => {
  let component: OldHinduLunarSpecialComponent;
  let fixture: ComponentFixture<OldHinduLunarSpecialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OldHinduLunarSpecialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OldHinduLunarSpecialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
