import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";

import {SharedModule} from "../../modules/shared.module";
import {HomeRoutingModule} from "./home-routing.module";
import { CabinetComponent } from './cabinet-page/cabinet.component';
import {CatalogComponent} from "./catalog-page/catalog.component";
import {HomeComponent} from "./home.component";
import {HeaderComponent} from "../../components/header/header.component";
import {PostComponent} from "../../components/post/post.component";
import {PostInformationComponent} from "../../components/post-information/post-information.component";

@NgModule({

  declarations: [
    CabinetComponent,
    CatalogComponent,
    HomeComponent,
    HeaderComponent,
    PostComponent,
    PostInformationComponent

  ],

  imports: [
    CommonModule,
    SharedModule,
    HomeRoutingModule,
  ]

})
export class HomeModule { }

