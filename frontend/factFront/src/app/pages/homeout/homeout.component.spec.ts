import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeoutComponent } from './homeout.component';

describe('HomeoutComponent', () => {
  let component: HomeoutComponent;
  let fixture: ComponentFixture<HomeoutComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HomeoutComponent]
    });
    fixture = TestBed.createComponent(HomeoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
