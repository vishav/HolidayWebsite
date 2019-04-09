import { TestBed } from '@angular/core/testing';

import { EcclesiasticalOrthodoxService } from './ecclesiastical-orthodox.service';

describe('EcclesiasticalOrthodoxService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EcclesiasticalOrthodoxService = TestBed.get(EcclesiasticalOrthodoxService);
    expect(service).toBeTruthy();
  });
});
