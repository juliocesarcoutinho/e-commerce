package br.com.topone.ecommerce.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
        liberacaoCors(response);

        /*Usado para teste no Postman*/
        response.getWriter().write("{\"Authorization\": \"" + token + "\"}");

    }

    /*Metodo que retorna o usuario validado pelo token caso não seja validado retorna null*/
    public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response){
        String token = request.getHeader(HEADER_STRING);

        if (token != null){
            String tokenLimpo = token.replace(TOKEN_PREFIX, "").trim();

            /*Faz a Liberação do token e obtem o usuario*/
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(tokenLimpo)
                    .getBody().getSubject();
        }
        liberacaoCors(response);
        return null;
    }

    /*Correção de erro de Cors nos navegadores*/
    private void liberacaoCors(HttpServletResponse response){
        if (response.getHeader("Access-Control-Allow-Origin") == null) {
            response.addHeader("Access-Control-Allow-Origin", "*");
        }
        if (response.getHeader("Access-Control-Allow-Headers") == null) {
            response.addHeader("Access-Control-Allow-Headers", "*");
        }
        if (response.getHeader("Access-Control-Request-Headers") == null) {
            response.addHeader("Access-Control-Request-Headers", "*");
        }
        if (response.getHeader("Access-Control-Allow-Methods") == null) {
            response.addHeader("Access-Control-Allow-Methods", "*");
        }
    }

}
