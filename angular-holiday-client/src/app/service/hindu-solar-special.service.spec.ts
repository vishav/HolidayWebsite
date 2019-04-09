import { TestBed } from '@angular/core/testing';

import { HinduSolarSpecialService } from './hindu-solar-special.service';

describe('HinduSolarSpecialService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HinduSolarSpecialService = TestBed.get(HinduSolarSpecialService);
    expect(service).toBeTruthy();
  });
});
