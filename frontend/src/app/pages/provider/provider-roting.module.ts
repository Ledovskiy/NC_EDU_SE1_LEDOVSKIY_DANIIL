import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {ProviderComponent} from './provider.component';
import {CreatePageComponent} from './create-page/create-page.component';
import {EditPageComponent} from './edit-page/edit-page.component';
import {DashboardPageComponent} from './dashboard-page/dashboard-page.component';


const routes: Routes = [
  {
    path: '', component: ProviderComponent,
    children: [
      {path: '', redirectTo: '/provider/create', pathMatch: 'full'},
      {path: 'create', component: CreatePageComponent},
      {path: 'post/:id/edit', component: EditPageComponent},
      {path: 'dashboard', component: DashboardPageComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProviderRoutingModule {
}
