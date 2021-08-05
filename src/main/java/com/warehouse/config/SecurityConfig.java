package com.warehouse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select username,password,enabled "
                        + " from employee "
                        + " where username = ? ")
                .authoritiesByUsernameQuery("select e.username, r.name "
                        + " from employee e, role r "
                        + " where e.username = ? "
                        + " AND e.roleID = r.roleID ");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic();
        http.formLogin().disable();
        http
                .authorizeRequests()
                .antMatchers("/employees/*").hasAnyAuthority("SRSPECIALIST","MANAGER","MATERIALHANDLER")
                .antMatchers("/restockhistory/*").hasAuthority("MANAGER")
                .antMatchers("/products/**").hasAnyAuthority("SRSPECIALIST","MANAGER","MATERIALHANDLER")
                .antMatchers("/products/newProduct").hasAnyAuthority("SRSPECIALIST","MANAGER")
                .antMatchers("/products/restock/*").hasAnyAuthority("SRSPECIALIST","MANAGER")
                .antMatchers("/tasks/**").hasAnyAuthority("SRSPECIALIST","MANAGER","MATERIALHANDLER")
                .antMatchers("/tasks/createTask").hasAnyAuthority("SRSPECIALIST","MANAGER")
                .antMatchers("/tasks/*/createList").hasAnyAuthority("SRSPECIALIST","MANAGER")
                .antMatchers("/tasks/*/accept").hasAnyAuthority("MATERIALHANDLER","MANAGER")
                .antMatchers("/").permitAll()
                .and().cors()
                .and().csrf().disable();
    }

}
