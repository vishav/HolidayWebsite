import { TestBed } from '@angular/core/testing';

import { HolidaysLocalesDetailsService } from './holidays-locales-details.service';

describe('HolidaysLocalesDetailsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HolidaysLocalesDetailsService = TestBed.get(HolidaysLocalesDetailsService);
    expect(service).toBeTruthy();
  });
});
