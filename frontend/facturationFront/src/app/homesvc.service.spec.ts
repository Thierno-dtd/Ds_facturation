import { TestBed } from '@angular/core/testing';

import { HomesvcService } from './homesvc.service';

describe('HomesvcService', () => {
  let service: HomesvcService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HomesvcService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
