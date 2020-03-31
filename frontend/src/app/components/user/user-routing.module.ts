import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

import {UserComponent} from "./user.component";
import {LandingComponent} from "./landing/landing.component";
import {UserCabinetComponent} from "./user-cabinet/user-cabinet.component";

const routes: Routes = [
  {path: 'user', component: UserComponent, children: [
      {path:'landing', component: LandingComponent },
      {path:'user-cabinet',component: UserCabinetComponent }
    ]}
];

@NgModule({
  imports:[RouterModule.forChild(routes)],
  exports:[RouterModule]
})
export class UserRoutingModule {

}
