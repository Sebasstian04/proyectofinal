import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOfertasComponent } from './add-ofertas.component';

describe('AddOfertasComponent', () => {
  let component: AddOfertasComponent;
  let fixture: ComponentFixture<AddOfertasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddOfertasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddOfertasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
