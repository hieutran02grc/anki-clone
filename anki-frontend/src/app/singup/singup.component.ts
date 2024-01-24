import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { GlobalConstants } from '../shared/global-constants';
import { NgxUiLoaderService } from 'ngx-ui-loader';
import { SnackbarService } from '../service/snackbar.service';

@Component({
  selector: 'app-singup',
  templateUrl: './singup.component.html',
  styleUrls: ['./singup.component.css']
})
export class SignupComponent implements OnInit {
  password = true;
  confirmPassword = true;
  signupForm: any = FormGroup;
  responseMessage: any = "";

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private userService: UserService,
    private snackbarService: SnackbarService,
    public dialogRef: MatDialogRef<SignupComponent>,
    private ngxService: NgxUiLoaderService
  ) { }

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      username: [null, [Validators.required]],
      // email:[null , Validators.required],
      contactNumber: [null, [Validators.required, Validators.pattern(GlobalConstants.contactRegex)]],
      password: [null, Validators.required],
      confirmPassword: [null, [Validators.required]],
      // phonenumber:[null , [Validators.required]],
      email: [null, Validators.required],
    })
  }

  validateSubmit() {
    if (this.signupForm.controls['password'].value != this.signupForm.controls['confirmPassword'].value) {
      return true;
    } else {
      return false;
    }
  }

  handleSubmit() {
    this.ngxService.start();
    var formDate = this.signupForm.value;
    var data = {
      username: formDate.username,
      email: formDate.email,
      contactNumber: formDate.contactNumber,
      password: formDate.password,
      phonenumber: formDate.phonenumber,
    }

    this.userService.signup(data).subscribe((response: any) => {
      console.log(response)
      this.ngxService.stop();
      this.responseMessage = response?.message;
      this.snackbarService.openSnackBar(this.responseMessage, "success");
      this.dialogRef.close();
      this.router.navigate(['/']);
    }, (error) => {
      this.ngxService.stop();
      if (error.error?.message) {
        this.responseMessage = error.error?.message;
      }
      else {
        this.responseMessage = GlobalConstants.genericError;
      }
      this.snackbarService.openSnackBar(this.responseMessage, GlobalConstants.error);
    })
  }

}

