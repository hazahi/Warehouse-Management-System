import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { Restock } from 'src/app/models/restock.model';
import { ProductService } from 'src/app/product.service';

@Component({
  selector: 'app-restock-history',
  templateUrl: './restock-history.component.html',
  styleUrls: ['./restock-history.component.scss']
})
export class RestockHistoryComponent implements OnInit {

  constructor(private productService:ProductService, private route:ActivatedRoute,private auth:AuthService) { }

  restocks:Restock[];

  ngOnInit(): void {
    this.productService.getRestockHistory().subscribe((lists:Restock[])=>{
      this.restocks=lists;
    })
  }
  logout(){
    this.auth.logout();
  }
}
  