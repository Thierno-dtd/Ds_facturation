package sever.com.serverFacturation.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sever.com.serverFacturation.dtos.*;
import sever.com.serverFacturation.entities.Categorie;
import sever.com.serverFacturation.entities.Facture;
import sever.com.serverFacturation.entities.Produit;
import sever.com.serverFacturation.entities.User;

@Service
public class ApplicationMappers {

    public UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public User convertDtoToEntity(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

    public Categorie convertDtoToEntity(CategorieDto categorieDto) {
        return Categorie.builder()
                .id(categorieDto.getId())
                .image(categorieDto.getImg())
                .designation(categorieDto.getDesignation())
                .build();
    }

    public CategorieDto convertEntityToDto(Categorie categorie) {
        return CategorieDto.builder()
                .id(categorie.getId())
                .designation(categorie.getDesignation())
                .img(categorie.getImage())
                .build();
    }

    public Produit convertDtoToEntity(ProduitDto produitDto) {
        return Produit.builder()
                .id(produitDto.getId())
                .prix(produitDto.getPrix())
                .nom(produitDto.getNom())
                .date_creation(produitDto.getDate_creation())
                .img(produitDto.getImg())
                .description(produitDto.getDescription())
                .categorie(Categorie.builder().id(produitDto.getCategorie_id()).build())
                .build();
    }

    public ProduitDto convertEntityToDto(Produit produit) {
        return ProduitDto.builder()
                .nom(produit.getNom())
                .prix(produit.getPrix())
                .categorie_id(produit.getCategorie().getId())
                .img(produit.getImg())
                .description(produit.getDescription())
                .date_creation(produit.getDate_creation())
                .build();
    }

    public Facture convertDtoToEntity(FacturerequestDto facturerequestDto){
        return Facture.builder()
                .produits(facturerequestDto.getProduits())
                .prix(facturerequestDto.getPrix())
                .client(facturerequestDto.getClient())
                .build();
    }

    public FactureDto convertEntityToDto(Facture facture){
        FactureDto factureDto = new FactureDto();
        BeanUtils.copyProperties(facture, factureDto);
        return factureDto;
    }
}
