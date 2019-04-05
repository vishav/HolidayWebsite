import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GregorianMonthdaySpecialComponent } from './gregorian-monthday-special.component';

describe('GregorianMonthdaySpecialComponent', () => {
  let component: GregorianMonthdaySpecialComponent;
  let fixture: ComponentFixture<GregorianMonthdaySpecialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GregorianMonthdaySpecialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GregorianMonthdaySpecialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
