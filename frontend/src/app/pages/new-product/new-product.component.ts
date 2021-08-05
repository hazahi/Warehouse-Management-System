import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product.model';
import{Router} from '@angular/router'
import { ProductService } from 'src/app/product.service';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.scss']
})
export class NewProductComponent implements OnInit {

  product:Product;
  constructor(private productService:ProductService,private router:Router) { }

  ngOnInit(): void {
  }

  createNewProduct(category:String,name:String,length:String,height:String,weight:String,price:String,numberInStock:String,locationAlley:String,locationSection:String){
    let lengthNumber:number=Number(length);
    let heightNumber:number=Number(height);
    let weightNumber:number=Number(weight);
    let priceNumber:number=Number(price);
    let stockNumber:number=Number(numberInStock);
    let location:String='Alley: '+locationAlley+', section: '+locationSection;
    return this.productService.createProduct(category,name,lengthNumber,heightNumber,weightNumber,priceNumber,stockNumber,location).subscribe((response:any)=>{
      
      this.router.navigate([`/product-info/${response.productID}`]);
    });

  }

}
