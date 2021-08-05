import { Injectable } from '@angular/core';
import { WebRequestService } from './web-request.service';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private webService:WebRequestService) { }

  getAllTasks(){
    return this.webService.get("tasks/all");
  }
  getAllCompletedTasks(){
    return this.webService.get("tasks/completed");
  }
  getAllPendingTasks(){
    return this.webService.get("tasks/pending");
  }
  getTaskWithID(taskID:number){
    let forgeString:string="tasks/"+taskID;
    return this.webService.get(forgeString);
  }
  getProductsForTask(taskID:number){
    let forgeString:string="tasks/"+taskID+"/products";
    return this.webService.get(forgeString);
  }
  createTask(description:string,taskAuthorID:number){
    return this.webService.post('tasks/createTask',{taskAuthorID,description});
  } 
  createTaskProductItem(productID:number,amount:number,taskID:number){
    let forgeString:string="tasks/"+taskID+"/createList";
    return this.webService.post(forgeString,{productID,amount});
  } 
  acceptTask(taskID:number,employeeID:number){
    let forgeString:string="tasks/"+taskID+"/accept";
    return this.webService.put(forgeString,{employeeID});
  }
  completeTask(taskID:number,taskFinisherID:number){
    let forgeString:string="tasks/"+taskID+"/complete";
    return this.webService.put(forgeString,{taskFinisherID});
  }
}
