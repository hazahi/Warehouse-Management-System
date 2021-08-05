import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { Task } from 'src/app/models/task.model';
import { TaskService } from 'src/app/task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit {

  tasks:Task[];

  constructor(private taskService:TaskService, private route:ActivatedRoute,private auth:AuthService) { }

  ngOnInit(): void {
    this.taskService.getAllPendingTasks().subscribe((lists:Task[])=>{
      this.tasks=lists;
  })
  }
  checkRestockHistoryButton(){
    if(this.auth.getAuthorityO()=="MANAGER"){
      return true;
    }
    else{
      return false;
    }
  }
  checkNewTaskButton(){
    if(this.auth.getAuthorityO()=="MATERIALHANDLER"){
      return false;
    }
    else{
      return true;
    }
  }
  loadCompleted(){
    this.taskService.getAllCompletedTasks().subscribe((lists:Task[])=>{
      this.tasks=lists;
  })
  }
  loadPending(){
    this.taskService.getAllPendingTasks().subscribe((lists:Task[])=>{
      this.tasks=lists;
  })
  }
  logout(){
    this.auth.logout();
  }

}
