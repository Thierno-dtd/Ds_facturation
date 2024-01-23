package sever.com.serverFacturation.dtos;

import com.flutter.project_flutter.constants.TypeRoles;
import com.flutter.project_flutter.entites.User;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    private BigDecimal solde;
    private String telephone;
    private LocalDate dateNaiss;
    private TypeRoles roles;


}
