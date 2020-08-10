package com.vicente.vicentedemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSucessHandler;

    @Autowired
    private AuthenticationFailureHandler myAuthenticationFailureHandler;


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                //用户认证处理
                .authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 关闭csrf防护
                .csrf().disable()
                .headers().frameOptions().disable()
                .and();
        http
                //登录处理
                .formLogin()
                .loginPage("/loginPage")
                .loginProcessingUrl("/form")
                .successHandler(myAuthenticationSucessHandler)
                .failureHandler(myAuthenticationFailureHandler)
                .permitAll()
                .and();
        http
                .authorizeRequests()
                //无需权限访问
                .antMatchers("/webjars/**", "/getVerifyCodeImage","/error/*").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                //其他接口需要登录后才能访问
                .anyRequest().authenticated()
                .and();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}