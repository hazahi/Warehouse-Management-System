import { Employee } from './employee.model';
import { productsForTasks } from './productsForTasks.model';

export class Task{
    taskID:number;
    taskAuthorID:number;
    taskFinisherID:number;
    description:string;
    productsForTasks:productsForTasks[];
    completionDate:Date;
    complete:boolean;
}