import { TestBed } from '@angular/core/testing';

import { FormulaNotesService } from './formula-notes.service';

describe('FormulaNotesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FormulaNotesService = TestBed.get(FormulaNotesService);
    expect(service).toBeTruthy();
  });
});
