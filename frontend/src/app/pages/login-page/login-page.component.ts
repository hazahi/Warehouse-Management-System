import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

   isAuthorizationUnsuccessfull:boolean=false;

  constructor(private auth:AuthService) { }

  ngOnInit(): void {
  }
  onLoginButtonClicked(username:string,password:string){
    this.auth.login(username,password).subscribe((res:HttpResponse<any>)=>{
      if(res.status===401){
        this.isAuthorizationUnsuccessfull=true;
      }
    });
  }

}
