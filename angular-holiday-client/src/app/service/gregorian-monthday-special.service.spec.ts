import { TestBed } from '@angular/core/testing';

import { GregorianMonthdaySpecialService } from './gregorian-monthday-special.service';

describe('GregorianMonthdaySpecialService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GregorianMonthdaySpecialService = TestBed.get(GregorianMonthdaySpecialService);
    expect(service).toBeTruthy();
  });
});
