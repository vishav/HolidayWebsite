import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GregorianNthkdayofmonthComponent } from './gregorian-nthkdayofmonth.component';

describe('GregorianNthkdayofmonthComponent', () => {
  let component: GregorianNthkdayofmonthComponent;
  let fixture: ComponentFixture<GregorianNthkdayofmonthComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GregorianNthkdayofmonthComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GregorianNthkdayofmonthComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
