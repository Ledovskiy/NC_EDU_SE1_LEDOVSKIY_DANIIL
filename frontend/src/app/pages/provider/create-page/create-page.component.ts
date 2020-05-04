import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ServiceModel} from '../../../model/service.model';
import {ServicesService} from "../../../services/fapi/services.service";


@Component({
  selector: 'app-create-page',
  templateUrl: './create-page.component.html',
  styleUrls: ['./create-page.component.css']
})
export class CreatePageComponent implements OnInit {

  form: FormGroup;

  editorStyle = {
    height: '300px;',
    backgroundColor: 'FF9900'
  };

  public services: ServiceModel[];

  constructor(private service: ServicesService) {
  }

  ngOnInit(): void {
    this.form = new FormGroup( {
      serviceName: new FormControl(null, Validators.required),
      information: new FormControl(null, Validators.required),
      price: new FormControl(null, [Validators.required, Validators.min(0)]),
    });
  }

  createService() {
    const newService: ServiceModel = {
      information: this.form.get('information').value,
      serviceName: this.form.get('serviceName').value,
      price: this.form.get('price').value,
    };
    this.service.createNewService(newService)
      .subscribe(() => console.log('OK'));

  }
}
