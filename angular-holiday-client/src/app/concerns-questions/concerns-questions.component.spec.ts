import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConcernsQuestionsComponent } from './concerns-questions.component';

describe('ConcernsQuestionsComponent', () => {
  let component: ConcernsQuestionsComponent;
  let fixture: ComponentFixture<ConcernsQuestionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConcernsQuestionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConcernsQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
