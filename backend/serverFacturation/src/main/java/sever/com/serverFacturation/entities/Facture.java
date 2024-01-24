package sever.com.serverFacturation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    private List<String> produits;
    private List<Double> prix;
    private int client;
    private Double montantTotal;
}
