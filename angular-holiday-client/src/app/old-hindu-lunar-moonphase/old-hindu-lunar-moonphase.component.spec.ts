import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OldHinduLunarMoonphaseComponent } from './old-hindu-lunar-moonphase.component';

describe('OldHinduLunarMoonphaseComponent', () => {
  let component: OldHinduLunarMoonphaseComponent;
  let fixture: ComponentFixture<OldHinduLunarMoonphaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OldHinduLunarMoonphaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OldHinduLunarMoonphaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
