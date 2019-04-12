import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OldHinduLunarComponent } from './old-hindu-lunar.component';

describe('OldHinduLunarComponent', () => {
  let component: OldHinduLunarComponent;
  let fixture: ComponentFixture<OldHinduLunarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OldHinduLunarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OldHinduLunarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
