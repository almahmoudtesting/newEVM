package com.example.CONFIGs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, userpassword, enabled"
                        + " from users where username=?")
                .authoritiesByUsernameQuery("select username, rolesname "
                        + "from users where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic().and()
                .authorizeRequests()
             //   .antMatchers("/home").permitAll()
//                .antMatchers("/adminpage").hasRole("Admin")
//                .antMatchers("/View").hasAnyRole("User","Admin")
                .antMatchers("/api/Users/AddUsers/**").permitAll()
              //  .antMatchers("/api/Users/UpdateUser/**").permitAll()
                //.antMatchers("/api/Users/AllUsers").permitAll()
               // .antMatchers("/UserData").permitAll()
             //   .antMatchers("/api/Events/AllEvents").permitAll()
                .anyRequest().authenticated();

    }
}