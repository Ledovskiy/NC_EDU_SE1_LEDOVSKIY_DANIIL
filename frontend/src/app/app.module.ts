import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule }   from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import {MatToolbarModule} from '@angular/material/toolbar';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {AuthModule} from "./pages/auth/auth.module";
import {UsersService} from "./services/users.service";
import {AuthService} from "./services/auth.service";
import {HomeModule} from "./pages/home/home.module";
import {SharedModule} from "./modules/shared.module";
import {ProviderModule} from "./pages/provider/provider.module";
import { ProviderCatalogPageComponent } from './pages/provider/provider-catalog-page/provider-catalog-page.component';






@NgModule({
  declarations: [
    AppComponent,
    ProviderCatalogPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AuthModule,
    HttpClientModule,
    HomeModule,
    ProviderModule,
    SharedModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatToolbarModule
  ],
  providers: [UsersService, AuthService],
  exports: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
