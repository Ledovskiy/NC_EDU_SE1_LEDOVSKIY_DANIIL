import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {HomeComponent} from './home.component';
import {CatalogComponent} from './catalog-page/catalog.component';
import {CabinetComponent} from './cabinet-page/cabinet.component';
import {ServiceInformationComponent} from '../../components/service-information/service-information.component';
import {WalletPageComponent} from './wallet-page/wallet-page.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent,
    children: [
      {path: '', redirectTo: '/home/catalog', pathMatch: 'full'},
      {path: 'catalog', component: CatalogComponent},
      {path: 'cabinet', component: CabinetComponent},
      {path: 'wallets', component: WalletPageComponent},
      {path: 'information/:id', component: ServiceInformationComponent},
      {path: '**', redirectTo: '/home/catalog'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule {
}
