import { TestBed } from '@angular/core/testing';

import { GregorianMonthdayMoonphaseService } from './gregorian-monthday-moonphase.service';

describe('GregorianMonthdayMoonphaseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GregorianMonthdayMoonphaseService = TestBed.get(GregorianMonthdayMoonphaseService);
    expect(service).toBeTruthy();
  });
});
