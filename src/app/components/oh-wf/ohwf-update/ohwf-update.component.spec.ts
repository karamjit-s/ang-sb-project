import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { OhwfUpdateComponent } from './ohwf-update.component';


describe('UpdateEmployeeComponent', () => {
  let component: OhwfUpdateComponent;
  let fixture: ComponentFixture<OhwfUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OhwfUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OhwfUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
