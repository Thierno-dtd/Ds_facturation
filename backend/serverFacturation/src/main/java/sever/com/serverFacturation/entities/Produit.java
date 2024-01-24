package sever.com.serverFacturation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private  Double prix;
    private LocalDate date_creation;
    private boolean active;
    private String description;
    private String img;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}
