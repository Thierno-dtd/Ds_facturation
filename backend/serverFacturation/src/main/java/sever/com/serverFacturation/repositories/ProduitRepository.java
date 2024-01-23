package sever.com.serverFacturation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sever.com.serverFacturation.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}
