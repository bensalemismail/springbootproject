package com.bensalem.springbootlearning.security;

import com.bensalem.springbootlearning.model.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.bensalem.springbootlearning.model.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().
                authorizeRequests()
                .antMatchers("/","/customer").permitAll()
                .antMatchers("/delete/**").hasAnyRole()
                .antMatchers("/update/**").hasAnyRole()
                .antMatchers("/add/**").hasAnyRole()
                .antMatchers("/list/**").hasAnyRole()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("ismail")
                .password(passwordEncoder.encode("pass123"))
                .roles(ADMIN.name())
                .build();

        UserDetails youssef = User.builder()
                .username("youssef")
                .password(passwordEncoder.encode("pass123?"))
                .roles(CUSTOMER.name())
                .build();


        return new InMemoryUserDetailsManager(admin,youssef);
    }







}
