import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GregorianMonthdayComponent } from './gregorian-monthday.component';

describe('GregorianMonthdayComponent', () => {
  let component: GregorianMonthdayComponent;
  let fixture: ComponentFixture<GregorianMonthdayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GregorianMonthdayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GregorianMonthdayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
