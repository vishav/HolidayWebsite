import { TestBed } from '@angular/core/testing';

import { FormulaExtensionsService } from './formula-extensions.service';

describe('FormulaExtensionsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FormulaExtensionsService = TestBed.get(FormulaExtensionsService);
    expect(service).toBeTruthy();
  });
});
