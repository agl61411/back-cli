package com.yi.backcli.util;

import com.yi.backcli.dao.AccountLoginDao;
import com.yi.backcli.entity.JwtUserDetail;
import com.yi.backcli.security.GrantedAuthorityImpl;
import com.yi.backcli.security.JwtAuthenticationToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

public class JwtTokenUtils implements Serializable {

    private static final long serialVersionUID = 4806577869049036269L;

    private static final String USERNAME = Claims.SUBJECT;

    private static final String CREATED = "created";

    private static final String AUTHORITIES = "authorities";

    private static final String SECRET = "CXMAGL";

    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;

    private static String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return Jwts.builder().setClaims(claims)
                            .setExpiration(expirationDate)
                            .signWith(SignatureAlgorithm.HS512, SECRET)
                            .compact();
    }

    public static String generateToken(Authentication authentication) {
        Map<String, Object> claims = new HashMap<>(3);
        claims.put(USERNAME, SecurityUtils.getUsername(authentication));
        claims.put(CREATED, new Date());
        claims.put(AUTHORITIES, authentication.getAuthorities());
        return generateToken(claims);
    }

    public static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public static String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public static String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String tokenHead = "Bearer ";

        if (token == null) {
            token = request.getHeader("token");
        } else if (token.contains(tokenHead)) {
            token = token.substring(tokenHead.length());
        }

        if ("".equals(token)) {
            token = null;
        }
        return token;
    }

    public static Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public static Boolean validateToken(String token, String username) {
        String userN = getUsernameFromToken(token);
        return (userN.equals(username) && !isTokenExpired(token));
    }

    public static Authentication getAuthenticationFromToken(HttpServletRequest request, AuthenticationManager manager) {
        Authentication authentication = null;
        String token = getToken(request);
        if (token != null) {
            if (SecurityUtils.getAuthentication() == null) {
                Claims claims = getClaimsFromToken(token);
                if (claims == null) {
                    return null;
                }
                String username = claims.getSubject();
                if (username == null) {
                    return null;
                }
                if (isTokenExpired(token)) {
                    return null;
                }

                Object authors = claims.get(AUTHORITIES);
                List<GrantedAuthority> authorities = new ArrayList<>();
                if (authors instanceof List) {
                    for (Object object: (List<?>) authors) {
                        authorities.add(new GrantedAuthorityImpl((String) ((Map<?, ?>) object).get("authority")));
                    }
                }

                authentication = new JwtAuthenticationToken(username, null, authorities, token);
            } else {
                if (validateToken(token, SecurityUtils.getUsername())) {
                    authentication = SecurityUtils.getAuthentication();
                }
            }
        }
        return authentication;
    }

    public static String refreshToken(String token) {
        String refreshToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put(CREATED, new Date());
            refreshToken = generateToken(claims);
        } catch (Exception e) {
            refreshToken = null;
        }
        return refreshToken;
    }
}
