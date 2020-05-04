import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MatToolbarModule} from '@angular/material/toolbar';

import {SharedModule} from '../../modules/shared.module';
import {ProviderComponent} from './provider.component';
import {ProviderRoutingModule} from './provider-roting.module';
import {CreatePageComponent} from './create-page/create-page.component';
import {EditPageComponent} from './edit-page/edit-page.component';
import {DashboardPageComponent} from './dashboard-page/dashboard-page.component';
import {HomeModule} from '../home/home.module';


@NgModule({
  declarations: [
    ProviderComponent,
    CreatePageComponent,
    EditPageComponent,
    DashboardPageComponent,

  ],
  imports: [
    ProviderRoutingModule,
    CommonModule,
    MatToolbarModule,
    SharedModule,
    HomeModule,
  ]
})
export class ProviderModule {
}
