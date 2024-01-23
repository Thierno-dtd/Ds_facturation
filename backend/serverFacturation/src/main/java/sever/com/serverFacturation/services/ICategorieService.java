package sever.com.serverFacturation.services;


import sever.com.serverFacturation.dtos.CategorieDto;
import sever.com.serverFacturation.entities.Categorie;

import java.util.List;

public interface ICategorieService {
    public CategorieDto enregister(CategorieDto categorieDto);
    public List<CategorieDto> getListCategorie();
    public CategorieDto getOneCategorie(int id);
    public void deleteCategorie(int id);
    public CategorieDto convertEntityToDto(Categorie categorie) ;
    public Categorie convertDtoToEntity(CategorieDto produitDto);

}
