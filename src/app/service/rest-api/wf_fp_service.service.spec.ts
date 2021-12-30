import { TestBed } from '@angular/core/testing';
import { wf_fp_service } from './wf_fp_service.service';

describe('OhWfService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: wf_fp_service = TestBed.get(wf_fp_service);
    expect(service).toBeTruthy();
  });
});
