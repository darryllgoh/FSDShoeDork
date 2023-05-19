package org.generation.FSDShoeDork.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private DataSource dataSource;

    /*  https://www.tabnine.com/code/java/methods/org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer/authoritiesByUsernameQuery
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from User where username=?")
                .authoritiesByUsernameQuery("select username, role from User where username=?");
    }
    /*
    https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/jdbc.html
    */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.formLogin().loginPage("/login");

        http.formLogin().defaultSuccessUrl("/upload", true);

        http.logout().logoutSuccessUrl("/index");

        http.authorizeHttpRequests((requests) -> {
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)
                    requests.requestMatchers("/", "/product/**", "/index", "/item/**", "/image/**", "/js/**", "/css/**",
                    "/productImages/**", "/login", "/aboutus", "/user/**", "/cart", "/shop", "/common/**")).permitAll().requestMatchers(new String[]{"/upload/**"})).hasRole("ADMIN");
        });
        return (SecurityFilterChain)http.build();
    }
}

