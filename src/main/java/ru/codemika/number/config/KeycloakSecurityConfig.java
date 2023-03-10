package ru.codemika.number.config;

import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        super.configure(http);
        http.cors().and().authorizeRequests()
                .antMatchers("/").permitAll()

                .antMatchers("/api/user/auth").permitAll()

                .antMatchers("/api/message/**",
                        "/api/group/**",
                        "/api/reaction/**"
                ).hasAnyRole("user", "admin")

                .antMatchers(HttpMethod.POST, "/api/group/**").hasAnyRole("user", "admin")
                .antMatchers(HttpMethod.GET, "/api/group/**").hasAnyRole("user", "admin")
                .antMatchers(HttpMethod.PUT, "/api/group/**").hasAnyRole("user", "admin")
                .antMatchers(HttpMethod.PUT,"/api/user/**").hasAnyRole("user")
                .antMatchers(HttpMethod.DELETE, "/api/group/**").hasAnyRole("admin")

                .antMatchers(HttpMethod.GET, "/api/user/**").hasAnyRole("user", "admin")
                .antMatchers( "/api/user/**").hasAnyRole("admin")

                .antMatchers(HttpMethod.GET, "/api/icon/**").hasAnyRole("user")

                .anyRequest().hasAnyRole("admin");
        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }
}
