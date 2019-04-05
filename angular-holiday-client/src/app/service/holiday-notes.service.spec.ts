import { TestBed } from '@angular/core/testing';

import { HolidayNotesService } from './holiday-notes.service';

describe('HolidayNotesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HolidayNotesService = TestBed.get(HolidayNotesService);
    expect(service).toBeTruthy();
  });
});
