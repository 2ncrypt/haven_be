package com.pain.haven.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //패스워드 해싱
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //    todo 테스트
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // CSRF 보호 비활성화
                .authorizeRequests()
                .anyRequest().permitAll()  // 모든 요청 허용 (개발용)
                .and()
                .formLogin().disable()  // 로그인 폼 비활성화
                .httpBasic().disable()  // 기본 인증 비활성화
                .logout().disable();  // 로그아웃 비활성화

        return http.build();
    }

//    todo 재설정
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/login", "/register", "/api/public/**").permitAll() // 특정 API는 인증 없이 허용
//                .anyRequest().authenticated() // 그 외 요청은 인증 필요
//                .and()
//                .formLogin()
//                .loginPage("/custom-login") // 사용자 정의 로그인 페이지 설정
//                .defaultSuccessUrl("/dashboard") // 로그인 성공 후 이동할 페이지
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout") // 로그아웃 URL
//                .logoutSuccessUrl("/login") // 로그아웃 후 이동할 페이지
//                .permitAll();
//
//        return http.build();
//    }
}
