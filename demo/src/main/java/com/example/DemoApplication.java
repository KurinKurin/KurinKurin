package com.example;

import static com.example.Controller.getSessionFactory;
import java.io.IOException;
import java.util.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

@SpringBootApplication
public class DemoApplication {
        
        @EnableGlobalMethodSecurity(prePostEnabled = true)
        @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
        protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

            @Override
            protected void configure(AuthenticationManagerBuilder builder) throws Exception {
                builder.inMemoryAuthentication().withUser("user").password("password").roles("USER");
            }

            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http
                        .httpBasic()
                        .and()
                        .authorizeRequests()
                        .antMatchers("/app/**","/logout","/login").permitAll()
                        .anyRequest().authenticated().and()
                        .logout().logoutSuccessUrl("/")
                        .and().csrf()
                        .csrfTokenRepository(csrfTokenRepository()).and()
                        .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
            }

            private Filter csrfHeaderFilter() {
                return new OncePerRequestFilter() {
                    @Override
                    protected void doFilterInternal(HttpServletRequest request,
                            HttpServletResponse response, FilterChain filterChain)
                            throws ServletException, IOException {
                        CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
                                .getName());
                        if (csrf != null) {
                            Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
                            String token = csrf.getToken();
                            if (cookie == null || token != null
                                    && !token.equals(cookie.getValue())) {
                                cookie = new Cookie("XSRF-TOKEN", token);
                                cookie.setPath("/");
                                response.addCookie(cookie);
                            }
                        }
                        filterChain.doFilter(request, response);
                    }
                };
            }

            private CsrfTokenRepository csrfTokenRepository() {
                HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
                repository.setHeaderName("X-XSRF-TOKEN");
                return repository;
            }

        }
    
        
	public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        
        
      
//        Tienda t = new Tienda(new TiendaId(1),"qwerty","calle falsa kappa", 1234567, "hola :C");
//        s.save(t);
//        tx.commit(); 
//        s.close();
//        sf.close();
//        System.out.println("*************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************salio el main :D");
            
	}
        
            public static SessionFactory getSessionFactory() {
        // loads configuration and mappings
       // builds a session factory from the service registry
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
