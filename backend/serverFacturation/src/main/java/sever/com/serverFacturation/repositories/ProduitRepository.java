package sever.com.serverFacturation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sever.com.serverFacturation.entities.Categorie;
import sever.com.serverFacturation.entities.Produit;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
    @Query("select c from Produit c where c.nom like :kw")
    List<Produit> findByNom(@Param("kw") String keyword);
    List<Produit> findByCategorieId(Categorie categorie);


}
