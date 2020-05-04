package backend.repository;

import backend.entity.Wallets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletsRepository extends JpaRepository<Wallets, Long> {
}
