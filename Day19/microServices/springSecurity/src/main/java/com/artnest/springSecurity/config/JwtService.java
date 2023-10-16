package com.artnest.springSecurity.config;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.artnest.springSecurity.model.User;
import com.artnest.springSecurity.repository.UserRepositories;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtService {
    private static final String SECRET_KEY =  "d26xCt3kZj6ZFxMvCtMNRCy9QCbpjY/lbpv/uB2JHil6dj97Xu2qRk4xc4i92GpOrr2tN1R+iH3b23nhqhTQORYcpqXurs+BGDG9XIN5z0Fdmsg7Wi7xxH94tcyvri8GzhIEpobLzzDbpEWYpXA16IaCKMJ1hzRQDIiSo1ON+u34V6s4eNpqIoYmnkmw5hDEh+wpJyAjXvJHs8GxessgeCZZOWDtmG860QgMqpNht5YPEVkxnK2l7ykeyCniuMzuK1hXQtydZLVEpZDg4cubKewqpMxZfm40TBI2BrZWPClIuypCweYf+4wnpDkh6gpCnIDyU6jXbFlV9jhOoafcuohmgBdb7rd8WS6moyulbIE=\r\n";
    
    private final UserRepositories userRepository;

    public <T> T extractClaim(String token, Function<Claims, T>claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails){
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        Map<String, Object> claims = new HashMap<>();
        claims.put("user", Map.of(
            "id", user.getId(),
            "name", user.getName(),
            "role", user.getRole()

        ));
        return generateToken(claims, userDetails);
    }

    

    private String generateToken(
        Map<String, Object> extraClaims,
        UserDetails userDetails
        
    ) {
        return Jwts
        .builder()
        .setClaims(extraClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
        .signWith(getSignInKey(), SignatureAlgorithm.HS256)
        .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }


   

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }


  private Claims extractAllClaims(String token){
    return Jwts
    .parserBuilder()
    .setSigningKey(getSignInKey())
    .build()
    .parseClaimsJws(token)
    .getBody();

  }

  private SecretKey getSignInKey(){
    byte[] keybytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keybytes);
  }

    
      





}
