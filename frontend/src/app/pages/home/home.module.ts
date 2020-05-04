import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SharedModule} from '../../modules/shared.module';
import {HomeRoutingModule} from './home-routing.module';
import { CabinetComponent } from './cabinet-page/cabinet.component';
import {CatalogComponent} from './catalog-page/catalog.component';
import {HomeComponent} from './home.component';
import {HeaderComponent} from '../../components/header/header.component';
import {ServiceComponent} from '../../components/service/service.component';
import {ServiceInformationComponent} from '../../components/service-information/service-information.component';
import {ServicesService} from '../../services/fapi/services.service';
import { WalletPageComponent } from './wallet-page/wallet-page.component';
import {WalletsService} from '../../services/wallets.service';
import {MatButtonModule} from "@angular/material/button";

@NgModule({

  declarations: [
    CabinetComponent,
    CatalogComponent,
    HomeComponent,
    HeaderComponent,
    ServiceComponent,
    ServiceInformationComponent,
    WalletPageComponent

  ],
  exports: [
    ServiceComponent
  ],

    imports: [
        CommonModule,
        SharedModule,
        HomeRoutingModule,
        MatButtonModule,
    ],
  providers: [
    ServicesService,
    WalletsService
  ]

})
export class HomeModule { }

