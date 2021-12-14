package com.bensalem.springbootlearning.security;


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
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


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

        http
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //.and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/customer").permitAll()
                .antMatchers("/delete/**").hasAnyRole()
                .antMatchers("/update/**").hasAnyRole()
                .antMatchers("/add/**").hasAnyRole()
                .antMatchers("/list/**").hasAnyRole()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll().defaultSuccessUrl("/customer/list",true);
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("pass123"))
                .roles(ADMIN.name())
                .build();

        UserDetails customer = User.builder()
                .username("customer")
                .password(passwordEncoder.encode("pass123?"))
                .roles(CUSTOMER.name())
                .build();

        UserDetails admin2 = User.builder()
                .username("admin2")
                .password(passwordEncoder.encode("pass123?"))
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails customer2 = User.builder()
                .username("customer2")
                .password(passwordEncoder.encode("pass123?"))
                .authorities(CUSTOMER.getGrantedAuthorities())
                .build();



        return new InMemoryUserDetailsManager(admin,customer,admin2,customer2);
    }







}
