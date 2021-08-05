import { Injectable } from '@angular/core';
import {WebRequestService} from './web-request.service';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private webRequestService:WebRequestService) { }

  createProduct(category:String,name:String,length:number,height:number,weight:number,price:number,numberInStock:number,location:String){
    return this.webRequestService.post('products/newProduct',{category,name,length,height,weight,price,numberInStock,location});
  }
  getProductList(){
    return this.webRequestService.get("products/all");
  }
  getRestockHistory(){
    return this.webRequestService.get("restockhistory/all");
  }
  restockProduct(productID:number,employeeID:number,amountRestocked:number){
   let urlString:string='products/restock/'+productID;
    return this.webRequestService.put(urlString,{employeeID,amountRestocked});
  }
  isEmptyOrWhiteSpaces(text:String){
    return text === null || text.match(/^ *$/) !== null;
  }
  searchProductList(searchText:String){
    if(this.isEmptyOrWhiteSpaces(searchText)){
      return this.getProductList();
    }
    else{
      return this.webRequestService.get("products/search/"+searchText);
    }
  }
  getProductById(searchId:number){
    return this.webRequestService.get(`products/product/${searchId}`);
  }
}
