import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IslamicSpecialComponent } from './islamic-special.component';

describe('IslamicSpecialComponent', () => {
  let component: IslamicSpecialComponent;
  let fixture: ComponentFixture<IslamicSpecialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IslamicSpecialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IslamicSpecialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
