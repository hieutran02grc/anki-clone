import { Component } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { LoginComponent } from '../login/login.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private dialog: MatDialog, private router:Router) {}

  handleLoginAction() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = "550px";
    this.dialog.open(LoginComponent, dialogConfig)
  }

  logout(){
    // const dialogConfig = new MatDialogConfig();
    // dialogConfig.data = {
    //   message:'Logout',
    //   configmation:true
    // };
    // const dialogRef = this.dialog.open(ConfirmationComponent, dialogConfig);
    // const sub = dialogRef.componentInstance.onEmistStatusChange.subscribe((response)=>{
      // dialogRef.close();
      localStorage.clear();
      this.router.navigate(['/']);
    // })
  }
}

