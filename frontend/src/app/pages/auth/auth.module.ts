import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {LoginComponent} from './login-page/login.component';
import {RegistrationComponent} from './registration-page/registration.component';
import {AuthRoutingModule} from './auth-routing.module';
import {AuthComponent} from './auth.component';
import {SharedModule} from '../../modules/shared.module';


@NgModule({
  declarations: [
    LoginComponent,
    RegistrationComponent,
    AuthComponent,
  ],

  imports: [
    CommonModule,
    AuthRoutingModule,
    SharedModule,
  ]

})
export class AuthModule {

}
