import { Component, OnInit } from '@angular/core';

import {WalletModel} from '../../../model/wallet.model';
import {WalletsService} from '../../../services/wallets.service';

@Component({
  selector: 'app-wallet-page',
  templateUrl: './wallet-page.component.html',
  styleUrls: ['./wallet-page.component.css']
})
export class WalletPageComponent implements OnInit {

  public wallets: WalletModel[];

  constructor(private wallet: WalletsService) {
  }

  ngOnInit(): void {
    this.wallet.getWallets()
      .subscribe((wallets: WalletModel[]) => this.wallets = wallets);

  }

}
