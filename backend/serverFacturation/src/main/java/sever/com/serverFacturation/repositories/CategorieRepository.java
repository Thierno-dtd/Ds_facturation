package sever.com.serverFacturation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sever.com.serverFacturation.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
