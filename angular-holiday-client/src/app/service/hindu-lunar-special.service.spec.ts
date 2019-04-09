import { TestBed } from '@angular/core/testing';

import { HinduLunarSpecialService } from './hindu-lunar-special.service';

describe('HinduLunarSpecialService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HinduLunarSpecialService = TestBed.get(HinduLunarSpecialService);
    expect(service).toBeTruthy();
  });
});
