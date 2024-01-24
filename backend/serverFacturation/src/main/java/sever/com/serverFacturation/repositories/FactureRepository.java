package sever.com.serverFacturation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sever.com.serverFacturation.entities.Facture;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Integer> {
    List<Facture> findByClient(int id);
}
