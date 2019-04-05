import { TestBed } from '@angular/core/testing';

import { ConcernsQuestionsService } from './concerns-questions.service';

describe('ConcernsQuestionsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ConcernsQuestionsService = TestBed.get(ConcernsQuestionsService);
    expect(service).toBeTruthy();
  });
});
