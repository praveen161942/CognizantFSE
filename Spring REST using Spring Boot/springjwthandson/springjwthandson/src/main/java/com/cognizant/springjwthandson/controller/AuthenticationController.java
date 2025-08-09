package com.cognizant.springjwthandson.controller;

import com.cognizant.springjwthandson.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        LOGGER.info("START - authenticate()");
        LOGGER.debug("Auth header: {}", authHeader);

        Map<String, String> map = new HashMap<>();
        map.put("token", "");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            LOGGER.warn("Missing or invalid Authorization header");
            return map;
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decodedBytes, StandardCharsets.UTF_8); // format "user:pwd"
        String[] parts = credentials.split(":", 2);
        if (parts.length != 2) {
            LOGGER.warn("Invalid Basic auth encoding");
            return map;
        }
        String username = parts[0];
        String password = parts[1];

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            // if no exception => success
            String token = jwtUtil.generateToken(username);
            map.put("token", token);
            LOGGER.info("END - authenticate()");
            return map;
        } catch (AuthenticationException ex) {
            LOGGER.warn("Authentication failed: {}", ex.getMessage());
            return map;
        }
    }
}
