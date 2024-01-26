package sever.com.serverFacturation.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProduitRequestDto {

    private String nom;
    private Double prix;
    private int quantite;
    private String description;
    private String img;
    private int categorie_id;
}
