import { AfterViewChecked, Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { LoginComponent } from '../login/login.component';
import { SignupComponent } from '../singup/singup.component';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {

  user = {
    "name" : "hieu",
  };

  // constructor(private dialog: MatDialog, private router: Router, private userSerivce: UserService) {
  // }

   constructor(private dialog: MatDialog, private router: Router, private userSerivce: UserService) {
  }


  ngOnInit(): void {
    // this.checkLogin();
  }

  handleSignupAction() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = "550px";
    this.dialog.open(SignupComponent, dialogConfig);
  }

  handleLoginAction() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = "550px";
    this.dialog.open(LoginComponent, dialogConfig)
  }

  checkLogin() {
    const userSring = localStorage.getItem('user');
    if (!userSring) return;
    this.router.navigate(['/cafe/dashboard']);
    const user = JSON.parse(userSring);
    this.userSerivce.setCurrentUser(user);
  }

}
