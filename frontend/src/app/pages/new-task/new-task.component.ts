import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { Product } from 'src/app/models/product.model';
import { productsForTasks } from 'src/app/models/productsForTasks.model';
import { ProductService } from 'src/app/product.service';
import { TaskService } from 'src/app/task.service';
import { ModalService } from 'src/app/_modal';

@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.scss']
})
export class NewTaskComponent implements OnInit {
  products:Product[];
  searchResults:Product[];
  targetedProduct:Product;
  amountCheck:boolean=false;
  addedCheck:boolean=false;
  productsForTasksList:productsForTasks[]=[];
  constructor(public modalService:ModalService,private productService:ProductService,private authService:AuthService,private taskService:TaskService,private router:Router) { }
  
  ngOnInit(): void {
    this.productService.getProductList().subscribe((lists:Product[])=>{
      this.products=lists;
      this.searchResults=this.products;
    });
  }
  searchForProduct(input:string){
    if(input==null){
      this.searchResults=this.products;
    }
    else{
      this.searchResults=this.products.filter(x=>x.name.includes(input));
    }
  }
  findProductById(productID:number){
    return this.products.find(x=>x.productID==productID);
  }
  setTargetedProduct(productID:number){
    this.targetedProduct=this.products.find(x=>x.productID==productID);
  }
  findProductName(productID:number){
   return this.findProductById(productID).name;
  }
  addProductToBePrepared(amountNumber:number){
    if(amountNumber>0){
    if(this.targetedProduct==null){
      return null;
    }
    else{
      if(this.targetedProduct.numberInStock<amountNumber){
        this.amountCheck=true;
        this.addedCheck=false;
      }
      else{
        this.productsForTasksList.push({productID:this.targetedProduct.productID,taskID:0,amount:amountNumber});
        console.log(this.productsForTasksList);
        this.amountCheck=false;
        this.addedCheck=true;
      }
    }
  }
}
  checkTarget(){
    if(this.targetedProduct==null){
      return false;
    }
    else{
      return true;
    }
  }
  checkAmount(){
    return this.amountCheck;
  }
  checkAddition(){
    return this.addedCheck;
  }
  createProducts(taskID:number){
    let counter:number=0;
    this.productsForTasksList.forEach((value)=>{
      this.taskService.createTaskProductItem(value.productID,value.amount,taskID).subscribe((response:any)=>{
        counter++;
        if(counter>=this.productsForTasksList.length){
          this.router.navigate([`/task-preview/${taskID}`]);
        }
      });
    });
    
  }
  confirmTaskCreation(description:string){
    this.taskService.createTask(description,this.authService.getUserID()).subscribe((response:any)=>{
      this.createProducts(response);
    });
  }

}
