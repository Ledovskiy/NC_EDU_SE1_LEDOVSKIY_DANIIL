import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {ServiceModel} from '../../model/service.model';

@Injectable()

export class ServicesService {

  constructor(private http: HttpClient) {
  }

  getService(id: string): Observable<ServiceModel> {
    return this.http.get<ServiceModel>(`http://localhost:8082/fapi/v1/services/${id}`);
  }

  getServices(): Observable<ServiceModel[]> {
    return this.http.get<ServiceModel[]>(`http://localhost:8082/fapi/v1/services`);
  }

  createNewService(service: ServiceModel): Observable<ServiceModel> {
    return this.http.post<ServiceModel>('http://localhost:8082/fapi/v1/services', service);
  }
}

