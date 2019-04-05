import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GregorianMonthdayMoonphaseComponent } from './gregorian-monthday-moonphase.component';

describe('GregorianMonthdayMoonphaseComponent', () => {
  let component: GregorianMonthdayMoonphaseComponent;
  let fixture: ComponentFixture<GregorianMonthdayMoonphaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GregorianMonthdayMoonphaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GregorianMonthdayMoonphaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
