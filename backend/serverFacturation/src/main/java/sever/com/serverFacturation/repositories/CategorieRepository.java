package sever.com.serverFacturation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sever.com.serverFacturation.entities.Categorie;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    Optional<Categorie> findByDesignation(String designation);
}
