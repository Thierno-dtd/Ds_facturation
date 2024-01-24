package sever.com.serverFacturation.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sever.com.serverFacturation.dtos.CategorieDto;
import sever.com.serverFacturation.dtos.ProduitDto;
import sever.com.serverFacturation.dtos.UserDto;
import sever.com.serverFacturation.entities.Categorie;
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
                .designation(categorieDto.getDesignation())
                .build();
    }

    public CategorieDto convertEntityToDto(Categorie categorie) {
        return CategorieDto.builder()
                .id(categorie.getId())
                .designation(categorie.getDesignation())
                .build();
    }

    public Produit convertDtoToEntity(ProduitDto produitDto) {
        return Produit.builder()
                .id(produitDto.getId())
                .prix(produitDto.getPrix())
                .nom(produitDto.getNom())
                .date_creation(produitDto.getDate_creation())
                .categorie(Categorie.builder().id(produitDto.getCategorie_id()).build())
                .build();
    }

    public ProduitDto convertEntityToDto(Produit produit) {
        return ProduitDto.builder()
                .nom(produit.getNom())
                .prix(produit.getPrix())
                .categorie_id(produit.getCategorie().getId())
                .date_creation(produit.getDate_creation())
                .build();
    }
}
