package com.uislancruz;

import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;

import java.util.Arrays;
import java.util.HashSet;

public class TokenGenerator {

    public static void main(String[] args) {
        // ~32 caracteres (256 bits ou mais)
        String secret = "minha-super-chave-bem-grande-123456";

        String token = Jwt.issuer("https://example.com/issuer")
                .upn("jdoe@quarkus.io")
                .groups(new HashSet<>(Arrays.asList("User", "Admin", "Subscriber")))
                .claim(Claims.preferred_username.name(), "jdoe")
                .claim(Claims.birthdate.name(), "2001-07-13")
                .signWithSecret(secret);

        System.out.println(token);
    }
}