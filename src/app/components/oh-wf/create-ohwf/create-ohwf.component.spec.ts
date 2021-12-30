import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { CreateOhwfComponent } from './create-ohwf.component';


describe('CreateOhwfComponent', () => {
  let component: CreateOhwfComponent;
  let fixture: ComponentFixture<CreateOhwfComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateOhwfComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateOhwfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
