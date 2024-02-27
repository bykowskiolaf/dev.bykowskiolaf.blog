//package dev.bykowskiolaf.blog.config;
//
//import dev.bykowskiolaf.blog.models.role.Role;
//import dev.bykowskiolaf.blog.models.role.Roles;
//import dev.bykowskiolaf.blog.models.user.User;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//
//import javax.sql.DataSource;
//import java.util.Collection;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//    @Bean
//    UserDetailsManager users(DataSource dataSource) {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{bcrypt}$2a$10$AiyMWI4UBLozgXq6itzyVuxrtofjcPzn/WS3fOrcqgzdax9jB7Io.")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{bcrypt}$2a$10$AiyMWI4UBLozgXq6itzyVuxrtofjcPzn/WS3fOrcqgzdax9jB7Io.")
//                .roles("USER", "ADMIN")
//                .build();
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(user);
//        users.createUser(admin);
//        return users;
//    }
//
//}