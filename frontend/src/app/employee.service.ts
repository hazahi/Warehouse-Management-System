import { Injectable } from '@angular/core';
import { WebRequestService } from './web-request.service';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private webReqService:WebRequestService) { }

  getEmployeeWithID(employeeID:number){
    let forgeString=+employeeID;
    return this.webReqService.get("employees/"+forgeString);
  }
}
