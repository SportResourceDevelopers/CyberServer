package com.cyber.controller;

import com.cyber.config.JwtTokenUtil;
import com.cyber.domain.JwtRequest;
import com.cyber.domain.JwtResponse;
import com.cyber.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "authenticate")
public class JwtAuthenticationController {

  private final AuthenticationManager authenticationManager;
  private final JwtTokenUtil jwtTokenUtil;
  private final JwtUserDetailsService jwtUserDetailsService;

  @Autowired
  public JwtAuthenticationController(AuthenticationManager authenticationManager,
                                     JwtTokenUtil jwtTokenUtil,
                                     JwtUserDetailsService jwtUserDetailsService) {
    this.authenticationManager = authenticationManager;
    this.jwtTokenUtil = jwtTokenUtil;
    this.jwtUserDetailsService = jwtUserDetailsService;
  }

  @PostMapping
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

    authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

    final UserDetails userDetails = jwtUserDetailsService
            .loadUserByUsername(authenticationRequest.getEmail());

    final String token = jwtTokenUtil.generateToken(userDetails);

    return ResponseEntity.ok(new JwtResponse(token));
  }

  private void authenticate(String username, String password) throws Exception {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }
}
