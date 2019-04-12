import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulaExtensionsComponent } from './formula-extensions.component';

describe('FormulaExtensionsComponent', () => {
  let component: FormulaExtensionsComponent;
  let fixture: ComponentFixture<FormulaExtensionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormulaExtensionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulaExtensionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
