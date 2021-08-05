import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router ,Params} from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { EmployeeService } from 'src/app/employee.service';
import { Employee } from 'src/app/models/employee.model';
import { productsForTasks } from 'src/app/models/productsForTasks.model';
import { Task } from 'src/app/models/task.model';
import { TaskService } from 'src/app/task.service';

@Component({
  selector: 'app-task-preview',
  templateUrl: './task-preview.component.html',
  styleUrls: ['./task-preview.component.scss']
})
export class TaskPreviewComponent implements OnInit {
  task:Task;
  taskFinisher:Employee;
  taskAuthor:Employee;
  productsForTask:productsForTasks[];
  constructor(private auth:AuthService,private taskService:TaskService,private route:ActivatedRoute,private router:Router,private employeeService:EmployeeService) { }

  ngOnInit(): void {
    this.route.params.subscribe((params:Params)=>{
      this.taskService.getTaskWithID(params.taskId).subscribe((response:Task)=>{
        this.task=response;      
        this.getTaskAuthor(response.taskAuthorID);
        this.getTaskFinisher(response.taskFinisherID);
        this.getProductsForTask(response.taskID);
      });
    });
  }
  getProductsForTask(taskID:number){
    this.taskService.getProductsForTask(taskID).subscribe((list:productsForTasks[])=>{
      this.productsForTask=list;
    });
  }
  getTaskAuthor(taskAuthorID:number){
    this.employeeService.getEmployeeWithID(taskAuthorID).subscribe((response:Employee)=>this.taskAuthor={
      employeeId:response.employeeId,
      name:response.name,
      role:response.role
    });
  }
  getTaskFinisher(taskFinisherID:number){
    if(this.task.taskFinisherID!=0){
      this.employeeService.getEmployeeWithID(taskFinisherID).subscribe((response:Employee)=>this.taskFinisher={
        employeeId:response.employeeId,
        name:response.name,
        role:response.role
      });
    }
  }
  acceptTask(){
    if(this.task.taskFinisherID==0&&!this.task.complete){
    this.taskService.acceptTask(this.task.taskID,this.auth.getUserID()).subscribe((response:Task)=>{
      this.task=response;      
        this.getTaskFinisher(response.taskFinisherID);
    });
    }
  }
  completeTask(){
    if(this.task.taskFinisherID!=0&&!this.task.complete){
      this.taskService.completeTask(this.task.taskID,this.auth.getUserID()).subscribe((response:Task)=>{
        this.task=response;      
          this.getTaskFinisher(response.taskFinisherID);
      });
      }
  }
  logout(){
    this.auth.logout();
  }
  checkAcceptButton(){
    if(this.auth.getAuthorityO()=="SRSPECIALIST"){
      return false;
    }
    else{
      if(this.task.complete){
        return false;
      }
      else{
        if(this.task.taskFinisherID==0){
          return true;
        }
        else{
          return false;
        }
      }
    }    
  }
  checkCompleteButton(){
    if(this.auth.getAuthorityO()=="SRSPECIALIST"){
      return false;
    }
    else{
      if(this.task.complete){
        return false;
      }
      else{
        if(this.task.taskFinisherID!=0){
          return true;
        }
        else{
          return false;
        }
      }
    }    
  }
checkRestockHistoryButton(){
  if(this.auth.getAuthorityO()=="MANAGER"){
    return true;
  }
  else{
    return false;
  }
}
checkFinishedByButton(){
  if(this.task.taskFinisherID!=0){
    if(this.task.complete){
      return true;
    }
    else{
      return false;
    }
  }
  else{
    return false;
  }
}
checkAcceptedByButton(){
  if(this.task.taskFinisherID!=0){
    if(this.task.complete){
      return false;
    }
    else{
      return true;
    }
  }
  else{
    return false;
  }
}
}
