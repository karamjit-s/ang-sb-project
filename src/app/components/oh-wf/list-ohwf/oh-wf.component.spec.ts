import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { OhWfComponent } from './oh-wf.component';


describe('OhWfComponent', () => {
  let component: OhWfComponent;
  let fixture: ComponentFixture<OhWfComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OhWfComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OhWfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
