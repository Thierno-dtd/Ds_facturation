package sever.com.serverFacturation.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sever.com.serverFacturation.dtos.FactureDto;
import sever.com.serverFacturation.dtos.FacturerequestDto;
import sever.com.serverFacturation.repositories.FactureRepository;
import sever.com.serverFacturation.services.serviceImpl.FactureService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/facrtures")
public class FactureController {
    private final FactureService factureService;
    @GetMapping("/")
    public ResponseEntity<List<FactureDto>> getFactureById(@PathVariable int id){
        return ResponseEntity.ok(factureService.getfactureByClientId(id));
    }

    @PostMapping("/")
    public ResponseEntity<FactureDto> registerFacture(@RequestBody FacturerequestDto facturerequestDto){
        return ResponseEntity.ok(factureService.registerFacture(facturerequestDto));
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteFacture(@PathVariable int id){
        factureService.deleteFacture(id);
        return ResponseEntity.accepted().build();
    }
}
