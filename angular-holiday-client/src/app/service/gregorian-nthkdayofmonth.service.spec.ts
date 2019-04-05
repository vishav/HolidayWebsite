import { TestBed } from '@angular/core/testing';

import { GregorianNthkdayofmonthService } from './gregorian-nthkdayofmonth.service';

describe('GregorianNthkdayofmonthService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GregorianNthkdayofmonthService = TestBed.get(GregorianNthkdayofmonthService);
    expect(service).toBeTruthy();
  });
});
