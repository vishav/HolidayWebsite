import { TestBed } from '@angular/core/testing';

import { IslamicSpecialService } from './islamic-special.service';

describe('IslamicSpecialService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IslamicSpecialService = TestBed.get(IslamicSpecialService);
    expect(service).toBeTruthy();
  });
});
