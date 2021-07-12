package io.github.leeseojune53.auth.security;

import io.github.leeseojune53.auth.entity.user.Role;
import io.github.leeseojune53.auth.security.jwt.FilterConfig;
import io.github.leeseojune53.auth.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().disable()
                .cors().and()
                .sessionManagement().disable()
                .csrf().disable();
        http.authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/auth").permitAll()
                .antMatchers(HttpMethod.GET, "/user/**").hasRole("USER")
                .anyRequest().authenticated()
                .and().apply(new FilterConfig(jwtTokenProvider))
                .and().exceptionHandling().accessDeniedPage("/register");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(15);
    }

}
