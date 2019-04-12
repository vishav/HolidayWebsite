import { TestBed } from '@angular/core/testing';

import { OldHinduLunarMoonphaseService } from './old-hindu-lunar-moonphase.service';

describe('OldHinduLunarMoonphaseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OldHinduLunarMoonphaseService = TestBed.get(OldHinduLunarMoonphaseService);
    expect(service).toBeTruthy();
  });
});
