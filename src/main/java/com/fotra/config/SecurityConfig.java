package com.fotra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.fotra.security.jwt.JwtConfigurer;
import com.fotra.security.jwt.JwtTokenProvider;

@Configuration
//@ComponentScan(basePackages = {"dto", "security", "service", "database"})
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware{

    private final JwtTokenProvider jwtTokenProvider;

    private static final String ADMIN_ENDPOINT = "/v1/admin/**";
    private static final String LOGIN_ENDPOINT = "/v/auth/**";
    private static final String ANON_ENDPOINT = "/perm/an/**";

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
	                .authorizeRequests()
	                .antMatchers(LOGIN_ENDPOINT).hasRole("USER")
	                .antMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
	                .antMatchers(ANON_ENDPOINT).permitAll()
	                .anyRequest().authenticated()
                .and()
                	.apply(new JwtConfigurer(jwtTokenProvider));
    }
}
