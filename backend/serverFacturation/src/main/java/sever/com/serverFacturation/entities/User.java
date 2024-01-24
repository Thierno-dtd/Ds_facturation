package sever.com.serverFacturation.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sever.com.serverFacturation.constants.TypeRoles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Le champ nom ne peut pas être vide.")
    private String nom;
    @NotBlank(message = "Le champ prénom ne peut pas être vide.")
    private String prenom;
    @Email(message = "L'adresse email n'est pas valide.")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Le champs password ne peut pas être vide.")
    private String passwd;

    private Double solde;
    private String telephone;
    private LocalDate dateNaiss;
    @Column(name = "userRole",nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeRoles roles;

    /*@OneToMany(mappedBy = "client")
    private List<Abonnement> abonnements;*/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(roles.name()));
    }

    @Override
    public String getPassword() {
        return passwd;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
