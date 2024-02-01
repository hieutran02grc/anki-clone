import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { NotFoundComponent } from './notfound.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { LoginComponent } from './login/login.component';
import {MatDialogModule} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DeskComponent } from './desk/desk.component';
import { SignupComponent } from './singup/singup.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { NgxUiLoaderModule } from 'ngx-ui-loader';
import { HTTP_INTERCEPTORS, HttpClientModule  } from '@angular/common/http';
import { AuthInterceptor } from './_interceptor/auth.interceptor';
import { DialogNewDesk } from './meterial-component/dialog/desk/newDesk.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NotFoundComponent,
    LoginComponent,
    DeskComponent,
    SignupComponent,
    DialogNewDesk,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatDialogModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatSnackBarModule,
    NgxUiLoaderModule,
    HttpClientModule,
    MatInputModule
     
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, multi: true, useClass:  AuthInterceptor}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
