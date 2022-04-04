package com.connor.fuel.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Base64;
import java.util.Map;

//note: The secret key must have a bit size >= the size of the output hash.
//note: using HMAC256 secret key >= 256 bits.
public class JWTHandler {
    private final String secret = "FED5A77F61E99149B25F6DDAABB21";

    /**
     * Creates and signs the JWT token
     * @param payload the payload of the JWT
     * @return signed JWT token
     */
    public String createSignJWT(Map<String, String> payload) {
        String token = null;
        try {
            Algorithm algorithmHS = Algorithm.HMAC256(secret);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withPayload(payload)
                    .sign(algorithmHS);
        } catch (JWTCreationException e) {
            //Invalid Signing configuration / Couldn't convert claims.
            System.out.println(e);
        }
       return token;
    }

    /**
     * Verify a JWT has been signed using the secret
     * @param token the JWT in question
     * @return the decoded JWT
     */
    public DecodedJWT verifyJWT(String token) {
        DecodedJWT jwt = null;
        try {
            Algorithm algorithmHS = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithmHS)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            jwt = verifier.verify(token);
        } catch (JWTVerificationException e) {
            //Invalid signature/claims
            System.out.println(e);
        }
        return jwt;
    }

    /**
     * Decodes the JWT using Base64
     * @param token the JWT in question
     * @return the decoded payload.
     */
    public String decodeJWTPayload(DecodedJWT token) {
        Base64.Decoder decoder = Base64.getUrlDecoder();
        return new String(decoder.decode(token.getPayload()));
    }






}
