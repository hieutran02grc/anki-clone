import { Component, AfterViewInit, OnInit } from '@angular/core';
import { DeskService } from '../service/desk.service';
import { Desk } from '../model/desk.model';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DialogNewDesk } from '../meterial-component/dialog/desk/newDesk.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {

  showAddFormFlag: boolean = false;
  newDeskName: string = '';
  listDesk!: Desk[];

  constructor(private deskService: DeskService,private dialog: MatDialog, private router: Router) {}

  ngOnInit(): void {
    this.deskService.getAllDesk().subscribe(
      (data) => {
        console.log(data);
        this.listDesk = data;
      },
      (error) => {
        // Handle error here
        console.error('Error fetching desk data:', error);
      }
    );
  }

  addNewDesk() {
	const dialogRef = this.dialog.open(DialogNewDesk);
	}


  learnDesk(desk: Desk) {
    console.log(desk.deskName);
  }


}
