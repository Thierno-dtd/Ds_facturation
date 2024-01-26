package sever.com.serverFacturation.services;


import sever.com.serverFacturation.dtos.ProduitDto;
import sever.com.serverFacturation.entities.Produit;

import java.util.List;

public interface IProduitService {
    public ProduitDto enregister(ProduitDto produitDto);
    public List<ProduitDto> getListProduct();
    public List<ProduitDto> getListProductByCatID(int id);
    public List<ProduitDto> getListProductByCategorieName(String categorieName);
    public ProduitDto getOneProduct(int id);
    public void deleteProduct(int id);
    public List<ProduitDto> search(String key);

}
