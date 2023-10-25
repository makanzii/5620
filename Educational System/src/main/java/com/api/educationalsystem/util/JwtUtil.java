package com.api.educationalsystem.util;

import com.api.educationalsystem.models.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    static Algorithm algorithm = Algorithm.HMAC256("elec5620");
    static JWTVerifier verifier = JWT.require(algorithm)
            .withIssuer("elec5620")
            .build();

    public static String generateToken(User user) {
        String jwtToken = JWT.create()
                .withIssuer("elec5620")
                .withSubject("elec5620")
                .withClaim("user", user.getNickName())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000L))
                .withJWTId(UUID.randomUUID()
                        .toString())
                .withNotBefore(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000L))
                .sign(algorithm);
        return jwtToken;
    }
}
