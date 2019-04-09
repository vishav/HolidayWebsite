import { TestBed } from '@angular/core/testing';

import { HinduLunarMoonphaseService } from './hindu-lunar-moonphase.service';

describe('HinduLunarMoonphaseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HinduLunarMoonphaseService = TestBed.get(HinduLunarMoonphaseService);
    expect(service).toBeTruthy();
  });
});
