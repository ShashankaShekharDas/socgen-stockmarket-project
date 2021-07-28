import { TestBed } from '@angular/core/testing';

import { ManageExchangeService } from './manage-exchange.service';

describe('ManageExchangeService', () => {
  let service: ManageExchangeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ManageExchangeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
