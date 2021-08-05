import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { NewProductComponent } from './pages/new-product/new-product.component';
import { NewTaskComponent } from './pages/new-task/new-task.component';
import { ProductInfoComponent } from './pages/product-info/product-info.component';
import { ProductListComponent } from './pages/product-list/product-list.component';
import { RestockHistoryComponent } from './pages/restock-history/restock-history.component';
import { RestockPreviewComponent } from './pages/restock-preview/restock-preview.component';
import { RestockComponent } from './pages/restock/restock.component';
import { TaskListComponent } from './pages/task-list/task-list.component';
import { TaskPreviewComponent } from './pages/task-preview/task-preview.component';

const routes: Routes = [
  {path: '', component: ProductListComponent},
  {path: 'login', component:LoginPageComponent},
  {path: 'new-product', component:NewProductComponent},
  {path: 'product-info/:productId',component:ProductInfoComponent},
  {path:'restock-product/:productId',component:RestockComponent},
  {path:'restock-preview/productId',component:RestockPreviewComponent},
  {path:'restockhistory',component:RestockHistoryComponent},
  {path:'task-list',component:TaskListComponent},
  {path: 'task-preview/:taskId',component:TaskPreviewComponent},
  {path:'new-task',component:NewTaskComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
