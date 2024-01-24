package sever.com.serverFacturation.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sever.com.serverFacturation.constants.TypeRoles;
import sever.com.serverFacturation.entities.User;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    //private int id;
    private String nom;

    private String prenom;
    private String email;
    private String passwd;
    private Double solde;
    private String telephone;
    private LocalDate dateNaiss;
    private TypeRoles roles;


}
