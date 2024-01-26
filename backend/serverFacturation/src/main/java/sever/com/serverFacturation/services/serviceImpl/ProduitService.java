package sever.com.serverFacturation.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sever.com.serverFacturation.dtos.ProduitDto;
import sever.com.serverFacturation.entities.Categorie;
import sever.com.serverFacturation.entities.Produit;
import sever.com.serverFacturation.exceptions.InvalidEntityException;
import sever.com.serverFacturation.mappers.ApplicationMappers;
import sever.com.serverFacturation.repositories.ProduitRepository;
import sever.com.serverFacturation.services.IProduitService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProduitService implements IProduitService {
    private final ProduitRepository produitRepository;
    private final ApplicationMappers applicationMappers;
    private  final CategorieService categorieService;
    @Override
    public ProduitDto enregister(ProduitDto produitDto) {
        return applicationMappers.convertEntityToDto(produitRepository
                .save(applicationMappers.convertDtoToEntity(produitDto)));
    }

    @Override
    public List<ProduitDto> getListProduct() {
        List<Produit> listProduits =  produitRepository.findAll();
        return listProduits.
                stream()
                    .map(produit ->applicationMappers.convertEntityToDto(produit))
                .collect(Collectors.toList());

    }

    @Override
    public List<ProduitDto> getListProductByCatID(int id) {
        List<Produit> lst = produitRepository.findByCategorieId(Categorie.builder().id(id).build());
        if(lst.isEmpty()) throw new InvalidEntityException("Catégorie invalid");
        else return lst.stream().map(produit -> applicationMappers.convertEntityToDto(produit)).collect(Collectors.toList());
    }

    @Override
    public List<ProduitDto> getListProductByCategorieName(String categorieName) {
        //List<Produit> lst = ;
        return null;
    }

    @Override
    public ProduitDto getOneProduct(int id) {
        Produit produit = produitRepository.findById(id).get();
        if(produit == null) new RuntimeException(" L'id du produit n'existe pas");
        return applicationMappers.convertEntityToDto(produit);
    }

    @Override
    public void deleteProduct(int id) {
        Produit produit = produitRepository.findById(id).orElseThrow(() -> new RuntimeException("produit not find to delete"));
        produitRepository.delete(produit);
    }

    @Override
    public List<ProduitDto> search(String key) {
        List<Produit> lst = produitRepository.findByNom(key);
        return lst.stream()
                .map(
                    produit -> applicationMappers.convertEntityToDto(produit)
                ).collect(Collectors.toList());
    }

}
