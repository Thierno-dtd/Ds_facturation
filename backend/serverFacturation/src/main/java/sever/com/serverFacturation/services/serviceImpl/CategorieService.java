package sever.com.serverFacturation.services.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sever.com.serverFacturation.dtos.CategorieDto;
import sever.com.serverFacturation.entities.Categorie;
import sever.com.serverFacturation.exceptions.InvalidEntityException;
import sever.com.serverFacturation.mappers.ApplicationMappers;
import sever.com.serverFacturation.repositories.CategorieRepository;
import sever.com.serverFacturation.services.ICategorieService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategorieService implements ICategorieService {
    private final CategorieRepository categorieRepository;
    private final ApplicationMappers applicationMappers;
    @Override
    public CategorieDto enregister(CategorieDto categorieDto) {
        return applicationMappers.convertEntityToDto(categorieRepository
                .save(applicationMappers.convertDtoToEntity(categorieDto)));
    }

    @Override
    public List<CategorieDto> getListCategorie() {
        //List<Categorie> listCategories =  categorieRepository.findAll();
        return categorieRepository.findAll()
                .stream()
                .map(categorie ->applicationMappers.convertEntityToDto(categorie))
                .collect(Collectors.toList());

    }

    @Override
    public CategorieDto getOneCategorie(int id) {
        Categorie categorie = categorieRepository.findById(id).get();
        if(categorie == null) new EntityNotFoundException(" Aucune catégorie pour l'ID : "+id);
        return applicationMappers.convertEntityToDto(categorie);
    }

    public Categorie getOneCategorieCat(int id) {
        Categorie categorie = categorieRepository.findById(id).get();
        if(categorie == null) new EntityNotFoundException(" Aucune catégorie pour l'ID : "+id);
        return categorie;
    }

    @Override
    public CategorieDto getOneCategorieByDesignation(String Name) {
        Categorie categorie = categorieRepository.findByDesignation(Name).orElse(null);
        if(categorie == null) throw new InvalidEntityException("Le nom de celle catégorie n'existe pas");
        return applicationMappers.convertEntityToDto(categorie);
    }

    @Override
    public void deleteCategorie(int id) {
        categorieRepository.deleteById(id);
    }

   /* @Override
    public CategorieDto convertEntityToDto(Categorie categorie) {
        CategorieDto categorieDto = new CategorieDto();
       // BeanUtils.copyProperties(categorie, categorieDto);
        categorieDto.setId(categorie.getId());
        categorieDto.setDesignation(categorie.getDesignation());
        return categorieDto;
    }*/
    //Deuxieme manière d'implementation




}
