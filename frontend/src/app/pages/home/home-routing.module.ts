import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

import {HomeComponent} from "./home.component";
import {CatalogComponent} from "./catalog-page/catalog.component";
import {CabinetComponent} from "./cabinet-page/cabinet.component";
import {PostInformationComponent} from "../../components/post-information/post-information.component";

const routes: Routes = [
  {path: '', component: HomeComponent,
    children: [
      {path: '', redirectTo: '/home/catalog', pathMatch: 'full'},
      {path:'catalog', component: CatalogComponent },
      {path:'cabinet', component: CabinetComponent },
      {path: 'post/:id', component: PostInformationComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
