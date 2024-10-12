package lk.ijse.gdse.aad67.NoteCollector_v2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//public class SecurityConfig {
//    @Value("${secure.username}")
//    private String userName;
//
//    @Value("${secure.password}")
//    private String password;
//
//    @Value("${secure.role}")
//    private String role;
//
//    @Bean//authentication check krana eka thmi meken krnne
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//        return http.build();
//
//    }
//    @Bean
//    //api regisyter krana user kenk return kragnn puluwn
//
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails userDetails = User.withDefaultPasswordEncoder()
//                .username(userName)
//                .password(password)
//                .roles(role)
//                .build();
//        return new InMemoryUserDetailsManager(userDetails);//application eke e welwe log wela inn userta kiyne pprincipal user kiyl
//    }
//}
