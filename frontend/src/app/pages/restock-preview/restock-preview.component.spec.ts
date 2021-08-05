import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestockPreviewComponent } from './restock-preview.component';

describe('RestockPreviewComponent', () => {
  let component: RestockPreviewComponent;
  let fixture: ComponentFixture<RestockPreviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestockPreviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestockPreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
