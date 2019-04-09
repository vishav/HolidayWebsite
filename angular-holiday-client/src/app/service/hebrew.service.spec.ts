import { TestBed } from '@angular/core/testing';

import { HebrewService } from './hebrew.service';

describe('HebrewService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HebrewService = TestBed.get(HebrewService);
    expect(service).toBeTruthy();
  });
});
