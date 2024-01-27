import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthentificateComponent } from './authentificate.component';

describe('AuthentificateComponent', () => {
  let component: AuthentificateComponent;
  let fixture: ComponentFixture<AuthentificateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AuthentificateComponent]
    });
    fixture = TestBed.createComponent(AuthentificateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
