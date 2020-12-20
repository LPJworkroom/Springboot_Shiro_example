package com.example.demo.util.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JWTUtil {
    private static final Logger LOG = LoggerFactory.getLogger(JWTUtil.class);

    public static boolean verify(String token,String userName,String secret){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", userName)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            LOG.info("token is invalid{}", e.getMessage());
            return false;
        }
    }


    public static Integer getUserId(String token){
        DecodedJWT jwt=JWT.decode(token);
        return jwt.getClaim("userId").asInt();
    }

}
