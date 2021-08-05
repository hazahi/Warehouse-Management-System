import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WebRequestService {
  readonly ROOT_URL;

  constructor(private http:HttpClient) {
    this.ROOT_URL="http://localhost:8080";
   }
  get(uri:string){
    return this.http.get(`${this.ROOT_URL}/${uri}`);
  }
  post(uri:string, payload:Object){
    return this.http.post(`${this.ROOT_URL}/${uri}`,payload);
  }
  put(uri:string, payload:Object){
    return this.http.put(`${this.ROOT_URL}/${uri}`,payload);
  }
  patch(uri:string, payload:Object){
    return this.http.patch(`${this.ROOT_URL}/${uri}`,payload);
  }
  delete(uri:string){
    return this.http.delete(`${this.ROOT_URL}/${uri}`);
  }
  login(uname:string,pass:string){
    let username:string=btoa(uname);
    let password:string=btoa(pass);
    const headers=new HttpHeaders({Authorizaton:"Basic "+btoa(uname+":"+pass)})
    return this.http.post(`${this.ROOT_URL}/login`,{username,password},{headers,observe:'response'})
  }
}
