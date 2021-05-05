package com.yi.backcli.config;

import com.yi.backcli.security.CustomAuthenticationEntryPoint;
import com.yi.backcli.security.JwtAuthenticationFilter;
import com.yi.backcli.security.JwtAuthenticationProvider;
import com.yi.backcli.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    public WebSecurityConfig(UserDetailsService userDetailsService, CustomAuthenticationEntryPoint authenticationEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new JwtAuthenticationProvider(userDetailsService));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();

        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);

        http.exceptionHandling().accessDeniedHandler((request, response, accessDeniedException) ->
            HttpUtils.write(response, 0, accessDeniedException.getMessage(), null)
        );

        http.logout().logoutSuccessHandler((request, response, authentication) ->
                HttpUtils.write(response, 200, "登出成功", null)
        );

        http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
