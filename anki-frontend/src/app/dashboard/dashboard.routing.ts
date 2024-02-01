import { Routes } from '@angular/router';

import { DashboardComponent } from './dashboard.component';
import { AppCardComponent } from '../card/card.component';

export const DashboardRoutes: Routes = [{
  path: '',
  component: DashboardComponent
},
{
  path: 'card',
  component: AppCardComponent
}];