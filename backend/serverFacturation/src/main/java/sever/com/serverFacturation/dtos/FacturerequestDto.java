package sever.com.serverFacturation.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sever.com.serverFacturation.entities.Produit;
import sever.com.serverFacturation.entities.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacturerequestDto {
    private List<String> produits;
    private List<Double> prix;
    private int client;
}
