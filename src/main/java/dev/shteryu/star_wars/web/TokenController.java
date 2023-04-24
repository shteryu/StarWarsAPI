package dev.shteryu.star_wars.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import dev.shteryu.star_wars.service.TokenManagerService;
import dev.shteryu.star_wars.web.dto.TokenRequest;
import dev.shteryu.star_wars.web.dto.TokenResponse;

@RestController
public class TokenController {

    @Autowired
    private UserDetailsService userService;

    @Autowired
    private TokenManagerService tokenManagerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public ResponseEntity<TokenResponse> obtainToken(@RequestBody TokenRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (DisabledException | BadCredentialsException e) {
            throw new RuntimeException(e.getMessage());
        }

        UserDetails user = userService.loadUserByUsername(request.getUsername());

        String token = tokenManagerService.generateJwtToken(user);

        return ResponseEntity.ok().body(
            TokenResponse.builder().token(token).build()
        );
    }
    
}
