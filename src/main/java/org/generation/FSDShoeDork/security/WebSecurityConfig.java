//package org.generation.FSDShoeDork.security;
//
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.context.annotation.*;
//import org.springframework.security.config.annotation.authentication.builders.*;
//import org.springframework.security.config.annotation.web.builders.*;
//import org.springframework.security.config.annotation.web.configuration.*;
//import org.springframework.security.crypto.bcrypt.*;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//import javax.sql.*;
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//
//    @Autowired
//    private DataSource dataSource;
//
//
//    /*  https://www.tabnine.com/code/java/methods/org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer/authoritiesByUsernameQuery
//     */
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.jdbcAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, enabled from users where username=?")
//                .authoritiesByUsernameQuery("select username, role from users where username=?");
//    }
//    /*
//    https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/jdbc.html
//    */
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable();
//
//
//        http.formLogin().loginPage("/login");
//
//
//        http.formLogin()
//                .defaultSuccessUrl("/productForm", true);
//
//
//
//
//        http.logout()
//                .logoutSuccessUrl("/index");
//
//
//        http.authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/", "/product", "/index","/item/**","/images/**","/js/**","/css/**", "/productImages/**","/login").permitAll()
//                .requestMatchers("/productForm/**").hasRole("ADMIN")
//        );
//        return http.build();
//    }
//}
//
