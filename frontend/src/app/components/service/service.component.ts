import {Component, OnInit} from '@angular/core';

import {ServiceModel} from '../../model/service.model';
import {ServicesService} from '../../services/fapi/services.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {

  public services: ServiceModel[];

  constructor(
    private router: Router,
    private service: ServicesService) {
  }

  ngOnInit(): void {
    this.service.getServices()
      .subscribe((services: ServiceModel[]) => this.services = services);

  }

  public showMoreInfo(id: string): void {
   this.router.navigate(['../../information/', id]);
   console.log(id);
  }

}

