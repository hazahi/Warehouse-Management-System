import { Injectable } from '@angular/core';
import {HttpInterceptor,HttpRequest,HttpHandler, HttpErrorResponse,HttpEvent} from '@angular/common/http';
import { AuthService } from './auth.service';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class WebReqInterceptor implements HttpInterceptor {

  constructor(private auth:AuthService) { }

  intercept(request:HttpRequest<any>,next:HttpHandler):Observable<HttpEvent<any>>{
    request=this.addAuthHeader(request);
    return next.handle(request).pipe(
      catchError((error:HttpErrorResponse)=>{
        if(error.status===401){
          this.auth.logout();
        }
        return throwError(error);
      })
    )
  }

  addAuthHeader(request:HttpRequest<any>){
    const authToken = this.auth.getAuthToken();
    const encodeType="Basic ";
    if(authToken!=null){
      return request.clone({
        setHeaders:{
          'Authorization' : encodeType+authToken
        }
      })
    }
    return request;
  }
}
