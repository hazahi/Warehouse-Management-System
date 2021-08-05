import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Params, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/auth.service';
import { Product } from 'src/app/models/product.model';
import { ProductService } from 'src/app/product.service';
@Component({
  selector: 'app-product-info',
  templateUrl: './product-info.component.html',
  styleUrls: ['./product-info.component.scss']
})
export class ProductInfoComponent implements OnInit {

  product:Product;

  constructor(private productService:ProductService,private route:ActivatedRoute,private auth:AuthService,private router:Router) { }

  ngOnInit(): void {
    this.route.params.subscribe((params:Params)=>{
      this.productService.getProductById(params.productId).subscribe((response:Product)=>this.product={
        productID: response.productID,
        categoryID: response.categoryID,
        name: response.name,
        locationInWarehouse: response.locationInWarehouse,
        length: response.length,
        height: response.height,
        weight: response.weight,
        price: response.price,
        numberInStock: response.numberInStock,
        numberShipped: response.numberShipped
      });
    });
  }
  checkRestockHistoryButton(){
    if(this.auth.getAuthorityO()=="MANAGER"){
      return true;
    }
    else{
      return false;
    }
  }
  checkRestockButton(){
    if(this.auth.getAuthorityO()=="MATERIALHANDLER"){
      return false;
    }
    else{
      return true;
    }
  }
  goToRestock(){
    this.router.navigate([`restock-product/${this.product.productID}`])
  }
  logout(){
    this.auth.logout();
  }

}
