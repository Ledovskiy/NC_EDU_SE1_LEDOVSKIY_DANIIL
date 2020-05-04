package backend.service;

import backend.entity.Wallets;
import backend.exeption.NotFoundException;

import java.util.List;

public interface WalletsService {

    Wallets getWallet(Long id) throws NotFoundException;

    Wallets saveWallet(Wallets wallets);

    Wallets updateWallet(Long id, Wallets wallets) throws NotFoundException;

    void deleteWallet(Long id);

    List<Wallets> getWallets();

    void deleteWallets();
}
