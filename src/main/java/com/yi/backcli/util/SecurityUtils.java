package com.yi.backcli.util;

import com.yi.backcli.security.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

public class SecurityUtils {

    public static JwtAuthenticationToken login(HttpServletRequest request,
                                               String username,
                                               String password,
                                               AuthenticationManager manager) {
        JwtAuthenticationToken token = new JwtAuthenticationToken(username, password, Collections.emptyList());
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        Authentication authentication = manager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        token.setToken(JwtTokenUtils.generateToken(authentication));
        return token;
    }

    public static void checkAuthentication(HttpServletRequest request, AuthenticationManager manager) {
        Authentication authentication = JwtTokenUtils.getAuthenticationFromToken(request, manager);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public static Authentication getAuthentication() {
        if (SecurityContextHolder.getContext() == null) {
            return null;
        }
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getUsername() {
        String username = null;
        Authentication authentication = getAuthentication();
        if (authentication != null) {
            username = authentication.getName();
        }
        return username;
    }

    public static String getUsername(Authentication authentication) {
        String username = null;
        if (authentication != null) {
            username = authentication.getName();
        }
        return username;
    }

}
