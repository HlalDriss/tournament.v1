package com.foot.tournament.security;

import com.foot.tournament.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().and().
        authorizeRequests().antMatchers("/login**","/css/**","/js/**","/scss/**","/img/**").
                    permitAll().
                anyRequest().
                authenticated().and().oauth2Login().loginPage("/login").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder=passwordEncoder();
        //System.out.println("############################");
       // System.out.println(passwordEncoder.encode("123"));
        //System.out.println("############################");
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        auth.authenticationProvider(authenticationProvider);

      //  System.out.println("#####################################################");
        //System.out.println(passwordEncoder.encode("123"));
   //     System.out.println("#####################################################");
//        auth.inMemoryAuthentication().withUser("user1").password("{noop}1234").roles("USER");
//        auth.inMemoryAuthentication().withUser("user2").password("{noop}1234").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("USER","ADMIN");

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
    }
}
