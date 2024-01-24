package sever.com.serverFacturation.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sever.com.serverFacturation.dtos.FactureDto;
import sever.com.serverFacturation.dtos.FacturerequestDto;
import sever.com.serverFacturation.dtos.UserDto;
import sever.com.serverFacturation.entities.Facture;
import sever.com.serverFacturation.entities.User;
import sever.com.serverFacturation.exceptions.InvalidOperationException;
import sever.com.serverFacturation.mappers.ApplicationMappers;
import sever.com.serverFacturation.repositories.FactureRepository;
import sever.com.serverFacturation.services.IFactureService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FactureService implements IFactureService {
    private final FactureRepository factureRepository;
    private final ApplicationMappers applicationMappers;
    private final UserService userService;
    private final ProduitService produitService;
    @Override
    public List<FactureDto> getfactureByClientId(int id) {
        UserDto user = userService.getOneUser(id);
        if(user!=null) {
            List<Facture> lst = factureRepository.findByClient(id);
            return lst.stream().map(fac ->applicationMappers.convertEntityToDto(fac)).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public FactureDto registerFacture(FacturerequestDto facturerequestDto) {
        UserDto user = userService.getOneUser(facturerequestDto.getClient());
        Facture facture = applicationMappers.convertDtoToEntity(facturerequestDto);
        facture.setDate(LocalDateTime.now());
        Double som = 0.0;
        for( Double fact : facturerequestDto.getPrix())
        {
            som+=fact;
        }
        if(user != null){
            if(user.getSolde()<som) throw new InvalidOperationException("le monton sur le compte est insuffissznt");
        }
        facture.setMontantTotal(som);
        userService.actualise(facturerequestDto.getClient(),som);
        return applicationMappers.convertEntityToDto(factureRepository.save(facture));
    }

    @Override
    public void deleteFacture(int id) {
        factureRepository.deleteById(id);
    }
}
