package sever.com.serverFacturation.services;

import sever.com.serverFacturation.dtos.FactureDto;
import sever.com.serverFacturation.dtos.FacturerequestDto;

import java.util.List;

public interface IFactureService {
    public List<FactureDto> getfactureByClientId(int id);
    public FactureDto registerFacture(FacturerequestDto facturerequestDto);
    public void deleteFacture(int id);

}
