import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { Product } from 'src/app/models/product.model';
import { ProductService } from 'src/app/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
    products:Product[];

  constructor(private productService:ProductService, private route:ActivatedRoute,private auth:AuthService) { }

  ngOnInit(): void {
    this.productService.getProductList().subscribe((lists:Product[])=>{
      this.products=lists;
    })
  }
  checkRestockHistoryButton(){
    if(this.auth.getAuthorityO()=="MANAGER"){
      return true;
    }
    else{
      return false;
    }
  }
  checkNewProductButton(){
    if(this.auth.getAuthorityO()=="MATERIALHANDLER"){
      return false;
    }
    else{
      return true;
    }
  }

  searchProducts(searchText:String){
    this.productService.searchProductList(searchText).subscribe((products:Product[])=>{
      this.products=products;
    })
  }
  logout(){
    this.auth.logout();
  }

}
