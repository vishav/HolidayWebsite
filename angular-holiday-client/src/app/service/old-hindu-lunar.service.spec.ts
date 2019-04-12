import { TestBed } from '@angular/core/testing';

import { OldHinduLunarService } from './old-hindu-lunar.service';

describe('OldHinduLunarService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OldHinduLunarService = TestBed.get(OldHinduLunarService);
    expect(service).toBeTruthy();
  });
});
