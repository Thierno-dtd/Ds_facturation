package sever.com.serverFacturation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sever.com.serverFacturation.dtos.CategorieDto;
import sever.com.serverFacturation.services.serviceImpl.CategorieService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @PostMapping("/")
    public ResponseEntity<CategorieDto>  register(@RequestBody CategorieDto categorieDto){
        return ResponseEntity.ok(categorieService.enregister(categorieDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<CategorieDto>>  getAllCategories(){
        return ResponseEntity.ok(categorieService.getListCategorie());
    }

    @GetMapping("/{categorie_id}")
    public ResponseEntity<CategorieDto> getOneCategorie(@PathVariable("categorie_id") int categorieId){
        return ResponseEntity.ok(categorieService.getOneCategorie(categorieId));
    }

    @PutMapping("/{categorie_id}")
    public ResponseEntity<CategorieDto> updateCategorie(@RequestBody CategorieDto categorieDto,
                                                        @PathVariable("categorie_id") int categorieId){
        categorieDto.setId(categorieId);
        return ResponseEntity.ok(categorieService.enregister(categorieDto));
    }

    @DeleteMapping("/{categorie_id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable("categorie_id") int categorieId){
        categorieService.deleteCategorie(categorieId);
        return ResponseEntity.accepted().build();
    }
}
