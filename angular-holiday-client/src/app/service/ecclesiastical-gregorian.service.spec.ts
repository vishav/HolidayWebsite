import { TestBed } from '@angular/core/testing';

import { EcclesiasticalGregorianService } from './ecclesiastical-gregorian.service';

describe('EcclesiasticalGregorianService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EcclesiasticalGregorianService = TestBed.get(EcclesiasticalGregorianService);
    expect(service).toBeTruthy();
  });
});
