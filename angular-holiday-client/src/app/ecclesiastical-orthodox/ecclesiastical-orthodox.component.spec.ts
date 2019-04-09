import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EcclesiasticalOrthodoxComponent } from './ecclesiastical-orthodox.component';

describe('EcclesiasticalOrthodoxComponent', () => {
  let component: EcclesiasticalOrthodoxComponent;
  let fixture: ComponentFixture<EcclesiasticalOrthodoxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EcclesiasticalOrthodoxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EcclesiasticalOrthodoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
