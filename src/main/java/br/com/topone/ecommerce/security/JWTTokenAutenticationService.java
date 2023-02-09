package br.com.topone.ecommerce.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/*Cria a autenticação e retorna a autenticação JWT*/
@Service
@Component
public class JWTTokenAutenticationService {

    /*Token de validade 11 dias */
    private static final long EXPIRATION_TIME = 959990000;
    private static final String SECRET = "";
    private static final String TOKEN_PREFIX = "Bearer";

    private static final String HEADER_STRING = "Authorization";

    /*Gera o token e da a reposta do JWT*/
    public void addAutentication(HttpServletResponse response, String usename) throws IOException {
        /*Montagem do token*/
        String JWT = Jwts.builder() /*Chama o Gerador de token*/
                .setSubject(usename) /*Adiciona o usuario*/
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) /*tempo de expiração*/
                .signWith(SignatureAlgorithm.ES512, SECRET)
                .compact();

        String token = TOKEN_PREFIX + " " + JWT;

        /* Da a resposta para a tela */
        response.addHeader(HEADER_STRING, token);

        /*Usado para teste no Postman*/
        response.getWriter().write("{\"Authorization\": \"" + token + "\"}");

    }

}
