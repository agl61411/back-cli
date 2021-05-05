package com.yi.backcli.util;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;

public class SecurityUtils {

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
