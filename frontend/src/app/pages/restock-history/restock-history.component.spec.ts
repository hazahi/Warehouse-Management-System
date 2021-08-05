import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestockHistoryComponent } from './restock-history.component';

describe('RestockHistoryComponent', () => {
  let component: RestockHistoryComponent;
  let fixture: ComponentFixture<RestockHistoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestockHistoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestockHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
