import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulaNotesComponent } from './formula-notes.component';

describe('FormulaNotesComponent', () => {
  let component: FormulaNotesComponent;
  let fixture: ComponentFixture<FormulaNotesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormulaNotesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulaNotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
