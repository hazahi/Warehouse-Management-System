import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Params, Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { ProductService } from 'src/app/product.service';

@Component({
  selector: 'app-restock',
  templateUrl: './restock.component.html',
  styleUrls: ['./restock.component.scss']
})
export class RestockComponent implements OnInit {
  productID:number;
  employeeID:number;
  constructor(private productService:ProductService,private route:ActivatedRoute,private auth:AuthService,private router:Router) { }

  ngOnInit(): void {
    this.route.params.subscribe((params:Params)=>{
      this.productID=params.productId;
      this.employeeID=this.auth.getUserID();
    });
  }
  restockProduct(amountToRestock:number){
    let amountRestocked:number=+amountToRestock;
    console.log(amountRestocked,this.employeeID,this.productID);
   return this.productService.restockProduct(this.productID,this.employeeID,amountRestocked).subscribe((response:any)=>{
      
    this.router.navigate([`/product-info/${response.productID}`]);
  });
  }
  returnToProductPage(){
    this.router.navigate([`/product-info/${this.productID}`]);
  }

}
