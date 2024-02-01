import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { DashboardRoutes } from "./dashboard.routing";
import { DashboardComponent } from "./dashboard.component";
import { HeaderComponent } from "../header/header.component";
import { AppCardComponent } from "../card/card.component";
import {MatSelectModule} from '@angular/material/select';
import { MatInputModule } from "@angular/material/input";

@NgModule({
  
    imports: [
      CommonModule,
      MatSelectModule,
      MatInputModule,
      RouterModule.forChild(DashboardRoutes)
    ],
    declarations: [DashboardComponent,
    HeaderComponent,
    AppCardComponent]
  })
  export class DashboardModule { }
  