package com.vicente.vicentedemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN")
                .and()
                .withUser("test").password(passwordEncoder().encode("test123")).roles("USER");

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
                //未登录时默认跳转页面
                .loginProcessingUrl("/login")
                .failureUrl("/loginError")
                .defaultSuccessUrl("/index")
                .permitAll()
                .and();
        http
                .authorizeRequests()
                //无需权限访问
                .antMatchers("/login**","/login/**", "/webjars/**", "/getVerifyCodeImage","/error/*").permitAll()
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