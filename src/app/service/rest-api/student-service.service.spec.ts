import { TestBed } from '@angular/core/testing';
import { StudentServiceService } from './student-service.service';

describe('student', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StudentServiceService = TestBed.get(StudentServiceService);
    expect(service).toBeTruthy();
  });
});
