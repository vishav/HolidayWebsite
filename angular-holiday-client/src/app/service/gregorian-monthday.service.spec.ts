import { TestBed } from '@angular/core/testing';

import { GregorianMonthdayService } from './gregorian-monthday.service';

describe('GregorianMonthdayService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GregorianMonthdayService = TestBed.get(GregorianMonthdayService);
    expect(service).toBeTruthy();
  });
});
