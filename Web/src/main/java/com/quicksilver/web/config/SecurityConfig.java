package com.quicksilver.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userService;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public SecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().permitAll()
//                .and().csrf().disable();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("css/**").permitAll()
                .antMatchers(HttpMethod.POST, "/login").hasAuthority("ADMIN")
                .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .successHandler(new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                                redirectStrategy.sendRedirect(request, response, "/applications");
                            }
                        })
                        .and().logout().logoutSuccessUrl("/login?logout").permitAll()
                .and().exceptionHandling().accessDeniedPage("/error/403")
                .and().userDetailsService(userService);
    }
}
