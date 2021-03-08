package com.zanol.scheduling.security.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zanol.scheduling.security.authentication.model.Credentials;

import javax.inject.Singleton;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Singleton
public class Authenticator {

    private static Authenticator authenticator;
    private final byte[] secret = Base64.getDecoder().decode("U0Rhc3NjaMOJZDBsaW5nMjNkNDU2IUAjIUAjw6dzNTI0YXNk");
    private final Algorithm algorithm = Algorithm.HMAC512(secret);
    private final String issuer = "Scheduling Authentication";
    private final String authScheme = "Bearer ";

    public static Authenticator getInstance() {
        if (Objects.isNull(authenticator)) {
            authenticator = new Authenticator();
        }

        return authenticator;
    }

    public String genarateToken(Credentials credentials) {
        return JWT.create()
                .withSubject(credentials.getUserCode())
                .withIssuer(issuer)
                .withIssuedAt(new Date())
                .withExpiresAt(
                        Date.from(
                                LocalDateTime.now().plusMinutes(30L)
                                        .atZone(ZoneId.systemDefault())
                                        .toInstant()
                        )
                )
                .sign(algorithm);
    }

    public Boolean isTokenValid(String token) {
        try {
            token = token.replace(authScheme, "");

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build();

            verifier.verify(token);

            return true;
        } catch (JWTVerificationException | NullPointerException e) {
            return false;
        }
    }

    public String getRequesterUserCode(String token) {
        try {
            token = token.replace(authScheme, "");

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT.getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    public SecurityContext createSecurityContext(String token) {
        return new SecurityContext() {
            @Override
            public Principal getUserPrincipal() {
                return () -> authenticator.getRequesterUserCode(token);
            }

            @Override
            public boolean isUserInRole(String s) {
                return false;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public String getAuthenticationScheme() {
                return null;
            }
        };
    }
}