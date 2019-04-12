import { TestBed } from '@angular/core/testing';

import { OldHinduLunarSpecialService } from './old-hindu-lunar-special.service';

describe('OldHinduLunarSpecialService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OldHinduLunarSpecialService = TestBed.get(OldHinduLunarSpecialService);
    expect(service).toBeTruthy();
  });
});
