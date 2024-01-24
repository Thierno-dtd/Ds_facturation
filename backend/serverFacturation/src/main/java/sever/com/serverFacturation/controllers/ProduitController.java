package sever.com.serverFacturation.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sever.com.serverFacturation.dtos.ProduitDto;
import sever.com.serverFacturation.services.serviceImpl.ProduitService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("produits")
public class ProduitController {
    private ProduitService produitService;

    @PostMapping("/")
    public ResponseEntity<ProduitDto> register(@RequestBody ProduitDto produitDto){
        return ResponseEntity.ok(produitService.enregister(produitDto));
    }

    @GetMapping("/")
    public  ResponseEntity<List<ProduitDto>> getAllProduits(){
        return ResponseEntity.ok(produitService.getListProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitDto> getOneProduit(@PathVariable int id){
        return ResponseEntity.ok(produitService.getOneProduct(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProduitDto> update(@RequestBody ProduitDto produitDto, @PathVariable int id){
        produitDto.setId(id);
        return ResponseEntity.ok(produitService.enregister(produitDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable int id){
        produitService.deleteProduct(id);
        return ResponseEntity.accepted().build();
    }
}
