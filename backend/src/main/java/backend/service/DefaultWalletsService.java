package backend.service;

import backend.entity.Wallets;
import backend.exeption.NotFoundException;
import backend.repository.WalletsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultWalletsService implements WalletsService {

    private final WalletsRepository walletsRepository;

    @Autowired
    public DefaultWalletsService(WalletsRepository walletsRepository) {
        this.walletsRepository = walletsRepository;
    }

    @Override
    public Wallets getWallet(Long id) throws NotFoundException {
        Optional<Wallets> wallets = walletsRepository.findById(id);
        if (wallets.isPresent()) {
            return wallets.get();
        } else {
            throw new NotFoundException("Wallets with id: " + id + " was not found");
        }
    }

    @Override
    public Wallets saveWallet(Wallets wallets) {
        return walletsRepository.save(wallets);
    }

    @Override
    public Wallets updateWallet(Long id, Wallets wallets) throws NotFoundException {
        Optional<Wallets> walletsToUpdateOptional = walletsRepository.findById(id);
        if (walletsToUpdateOptional.isPresent()) {
            Wallets walletsToUpdate = this.updateWalletsFields(walletsToUpdateOptional.get(), wallets);
            return walletsRepository.save(walletsToUpdate);
        } else {
            throw new NotFoundException("Wallets with id: " + id + " was not found");
        }
    }

    @Override
    public void deleteWallet(Long id) {
        walletsRepository.deleteById(id);
    }

    @Override
    public List<Wallets> getWallets() {
        return walletsRepository.findAll();
    }

    @Override
    public void deleteWallets() {
        walletsRepository.deleteAll();
    }

    private Wallets updateWalletsFields(Wallets walletsToUpdate, Wallets newWallets) {

        if (newWallets.getBalance() != null) {
            walletsToUpdate.setBalance(newWallets.getBalance());
        }

        if (newWallets.getWalletName() != null) {
            walletsToUpdate.setWalletName(newWallets.getWalletName());
        }

        return walletsToUpdate;
    }
}
