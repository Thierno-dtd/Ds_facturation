import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeoldComponent } from './homeold.component';

describe('HomeoldComponent', () => {
  let component: HomeoldComponent;
  let fixture: ComponentFixture<HomeoldComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HomeoldComponent]
    });
    fixture = TestBed.createComponent(HomeoldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
