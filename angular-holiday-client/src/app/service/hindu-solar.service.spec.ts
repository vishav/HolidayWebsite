import { TestBed } from '@angular/core/testing';

import { HinduSolarService } from './hindu-solar.service';

describe('HinduSolarService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HinduSolarService = TestBed.get(HinduSolarService);
    expect(service).toBeTruthy();
  });
});
