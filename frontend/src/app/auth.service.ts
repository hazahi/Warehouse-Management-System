import { HttpClient,HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { WebRequestService } from './web-request.service';
import {shareReplay,tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient,private webService:WebRequestService,private router:Router) {
    
   }
   login(username:string,password:string){
     return this.webService.login(username,password).pipe(
        tap((res:HttpResponse<any>)=>{
          if(res.status!=401 && res.status!=403){
            this.router.navigateByUrl("/");
            this.setSession(res.body.employeeId,res.body.role,username,password);
          }
        })
      );
   }
   logout(){    
    this.removeSession();
    this.router.navigateByUrl("/login");
  }
  getAuthToken(){
   return sessionStorage.getItem('at');
  }
  getUserID():number{
    let userID:number=+atob(sessionStorage.getItem("ed"));
    return userID;
  }
  getAuthorityO():string{
    let role:string= atob(sessionStorage.getItem("rv"));
    return role;
  }
   private setSession(userID:string,role:string,username:string,password:string){
     sessionStorage.setItem("ed",btoa(userID));
     sessionStorage.setItem('at',btoa(username+":"+password));
    sessionStorage.setItem("rv",btoa(role))
   }
   private removeSession(){
    sessionStorage.removeItem("ed");
    sessionStorage.removeItem("at");
    sessionStorage.removeItem("rv");
  }
  
}
