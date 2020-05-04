import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {WalletModel} from '../model/wallet.model';

@Injectable()

export class WalletsService {

  constructor(private http: HttpClient) {
  }

  getWallets(): Observable<WalletModel[]> {
    return this.http.get<WalletModel[]>(`http://localhost:8082/fapi/v1/wallets`);
  }

}
