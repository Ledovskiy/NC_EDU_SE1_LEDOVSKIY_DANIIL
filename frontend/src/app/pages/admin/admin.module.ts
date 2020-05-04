import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AdminRoutingModule} from './admin-routing.module';
import {UserlistPageComponent} from './userlist-page/userlist-page.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {SharedModule} from '../../modules/shared.module';
import {AdminComponent} from './admin.component';
import {MatTableModule} from "@angular/material/table";


@NgModule({
  declarations: [
    AdminComponent,
    UserlistPageComponent,
  ],
    imports: [
        CommonModule,
        AdminRoutingModule,
        MatToolbarModule,
        SharedModule,
        MatTableModule,
    ]
})
export class AdminModule {
}
