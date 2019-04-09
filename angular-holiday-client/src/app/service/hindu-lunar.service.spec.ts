import { TestBed } from '@angular/core/testing';

import { HinduLunarService } from './hindu-lunar.service';

describe('HinduLunarService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HinduLunarService = TestBed.get(HinduLunarService);
    expect(service).toBeTruthy();
  });
});
