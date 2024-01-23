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
public class ProduitDto {
    private int id;
    private String nom;
    private Double prix;
    private LocalDate date_creation;
    private int categorie_id;
}
