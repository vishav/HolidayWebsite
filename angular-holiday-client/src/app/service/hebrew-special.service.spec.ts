import { TestBed } from '@angular/core/testing';

import { HebrewSpecialService } from './hebrew-special.service';

describe('HebrewSpecialService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HebrewSpecialService = TestBed.get(HebrewSpecialService);
    expect(service).toBeTruthy();
  });
});
