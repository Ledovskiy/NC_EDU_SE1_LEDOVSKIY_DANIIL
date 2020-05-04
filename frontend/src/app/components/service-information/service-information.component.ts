import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ServiceModel} from '../../model/service.model';
import {ServicesService} from '../../services/fapi/services.service';

@Component({
  selector: 'app-service-information',
  templateUrl: './service-information.component.html',
  styleUrls: ['./service-information.component.css']
})
export class ServiceInformationComponent implements OnInit {

  public infoService: ServiceModel;
  id: string;
  constructor(private activateRoute: ActivatedRoute,
              private service: ServicesService) {
  }

  ngOnInit(): void {

    this.id = this.activateRoute.snapshot.params.id;
    this.service.getService(this.id)
      .subscribe((service: ServiceModel) => this.infoService = service);
  }
}
