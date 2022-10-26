import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDuyuruComponent } from './admin-duyuru.component';

describe('AdminDuyuruComponent', () => {
  let component: AdminDuyuruComponent;
  let fixture: ComponentFixture<AdminDuyuruComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDuyuruComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminDuyuruComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
