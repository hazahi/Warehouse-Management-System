import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './pages/product-list/product-list.component';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NewProductComponent } from './pages/new-product/new-product.component';
import { ProductInfoComponent } from './pages/product-info/product-info.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { WebReqInterceptor } from './web-req-interceptor.service';
import { RestockComponent } from './pages/restock/restock.component';
import { TaskListComponent } from './pages/task-list/task-list.component';
import { TaskPreviewComponent } from './pages/task-preview/task-preview.component';
import { NewTaskComponent } from './pages/new-task/new-task.component';
import { RestockHistoryComponent } from './pages/restock-history/restock-history.component';
import { RestockPreviewComponent } from './pages/restock-preview/restock-preview.component';
import {ModalModule} from'./_modal';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    NewProductComponent,
    ProductInfoComponent,
    LoginPageComponent,
    RestockComponent,
    TaskListComponent,
    TaskPreviewComponent,
    NewTaskComponent,
    RestockHistoryComponent,
    RestockPreviewComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ModalModule
  ],
  providers: [
    {
      provide:HTTP_INTERCEPTORS, useClass:WebReqInterceptor,multi:true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
