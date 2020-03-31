import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";

import {SharedModule} from "../../modules/shared.module";
import {UserRoutingModule} from "./user-routing.module";
import { UserCabinetComponent } from './user-cabinet/user-cabinet.component';
import {LandingComponent} from "./landing/landing.component";
import {UserComponent} from "./user.component";

@NgModule({

  imports: [
    CommonModule,
    SharedModule,
    UserRoutingModule
  ],

  declarations: [
    UserCabinetComponent,
    LandingComponent,
    UserComponent
  ]
})
export class UserModule { }

