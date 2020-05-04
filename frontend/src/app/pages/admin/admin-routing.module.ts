import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {AdminComponent} from './admin.component';
import {UserlistPageComponent} from './userlist-page/userlist-page.component';


const routes: Routes = [
  {
    path: '', component: AdminComponent,
    children: [
      {path: '', redirectTo: '/admin/user-list', pathMatch: 'full'},
      {path: 'user-list', component: UserlistPageComponent},
      {path: '**', redirectTo: '/admin/user-list'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {
}
