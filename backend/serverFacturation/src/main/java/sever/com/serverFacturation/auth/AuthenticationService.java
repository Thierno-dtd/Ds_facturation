package sever.com.serverFacturation.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sever.com.serverFacturation.config.JwtService;
import sever.com.serverFacturation.entities.User;
import sever.com.serverFacturation.exceptions.EntityNotFoundException;
import sever.com.serverFacturation.repositories.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository utilisateurRepository;

    @Autowired
    public AuthenticationService(UserRepository utilisateurRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    private PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user= User.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .passwd(passwordEncoder.encode(request.getPasswd()))
                .telephone(request.getTelephone())
                .solde(0.0)
                .dateNaiss(request.getDateNaiss())
                .build();
        utilisateurRepository.save(user);
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        UserDetails user=utilisateurRepository.findByEmail(request.getEmail()).orElseThrow(()-> new EntityNotFoundException("aucun utilisateur n'est trouvé!"));
        String jwtToken="";
        if(passwordEncoder.matches(request.getPassword(),user.getPassword())){
            jwtToken=jwtService.generateToken(user);
        }
        UserDetails user1=utilisateurRepository.findByEmail(request.getEmail()).orElseThrow(()-> new EntityNotFoundException("aucun utilisateur n'est trouvé!"));
        if(!StringUtils.hasLength(user1.getUsername())){
            log.warn("le username de ce utilisateur est nul");
        }

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}