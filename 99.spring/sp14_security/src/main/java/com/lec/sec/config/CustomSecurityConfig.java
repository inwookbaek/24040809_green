package com.lec.sec.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.lec.sec.security.Custom403Handler;
import com.lec.sec.security.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class CustomSecurityConfig {

	// p704 주입필요
	private final DataSource dataSource;
	private final CustomUserDetailsService userDetailsService;	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        log.info("------------configure-------------------");
        
//        http.formLogin();
//        http.formLogin().loginPage("/member/login");
        http.formLogin(login -> login.loginPage("/member/login"));
        
        // p699 -CSRF 토큰 비활성화
        http.csrf(csrf -> csrf.disable());

        http.rememberMe(me -> me
                .key("12345678")
                .tokenRepository(persistentTokenRepository())
                .userDetailsService(userDetailsService)
                .tokenValiditySeconds(60*60*24*30));
        
        // http.exceptionHandling().accessDeniedHandler(accessDeniedHandler()); // depricated 403
        http.exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedHandler(accessDeniedHandler())); //403
        
        return http.build();
    }
    
    
    // 683 정적자원(css, js)들은 스프링시큐리티 적용에서 제외
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
    	
    	log.info("------------web configure-------------------");
    	return (web) -> web.ignoring()
    					   .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
    
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        return repo;
    } 
    
    // p718
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
    	return new Custom403Handler();
    }    
}
