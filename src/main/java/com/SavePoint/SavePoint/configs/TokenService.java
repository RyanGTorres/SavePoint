package com.SavePoint.SavePoint.configs;

import com.SavePoint.SavePoint.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenService {
    @Value("${JWT_SECRET_KEY}")
    private String secretKey;

    @Value("${JWT_EXPIRATION_TIME}")
    private Long timeJwt;


    public String generateToken(User user){


        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        return JWT.create()
                .withSubject(user.getNickname())
                .withClaim("id", user.getId())
                .withClaim("email", user.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(timeJwt))
                .withIssuedAt(Instant.now())
                .withIssuer("Gerado pela API SavePoint")
                .sign(algorithm);
    }

    public Optional<JWTUserData> verifyToken(String token){


        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        try {
            DecodedJWT verify = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return Optional.of(JWTUserData
                    .builder()
                    .id(verify.getClaim("UserID").asLong())
                    .nickname(verify.getClaim("UserName").asString())
                    .email(verify.getClaim("UserEmail").asString())
                    .build());

        }catch (JWTVerificationException ex){
            return Optional.empty();
        }
    }


}




