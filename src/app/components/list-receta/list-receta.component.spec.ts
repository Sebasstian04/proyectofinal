import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListRecetaComponent } from './list-receta.component';

describe('ListRecetaComponent', () => {
  let component: ListRecetaComponent;
  let fixture: ComponentFixture<ListRecetaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListRecetaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListRecetaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
