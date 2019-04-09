import { TestBed } from '@angular/core/testing';

import { IslamicService } from './islamic.service';

describe('IslamicService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IslamicService = TestBed.get(IslamicService);
    expect(service).toBeTruthy();
  });
});
