import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GregorianKdayafteretcMonthdayComponent } from './gregorian-kdayafteretc-monthday.component';

describe('GregorianKdayafteretcMonthdayComponent', () => {
  let component: GregorianKdayafteretcMonthdayComponent;
  let fixture: ComponentFixture<GregorianKdayafteretcMonthdayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GregorianKdayafteretcMonthdayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GregorianKdayafteretcMonthdayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
