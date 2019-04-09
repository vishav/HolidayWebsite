import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EcclesiasticalGregorianComponent } from './ecclesiastical-gregorian.component';

describe('EcclesiasticalGregorianComponent', () => {
  let component: EcclesiasticalGregorianComponent;
  let fixture: ComponentFixture<EcclesiasticalGregorianComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EcclesiasticalGregorianComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EcclesiasticalGregorianComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
