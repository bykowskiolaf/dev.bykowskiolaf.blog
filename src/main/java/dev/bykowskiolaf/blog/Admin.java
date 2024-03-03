package dev.bykowskiolaf.blog;

import dev.bykowskiolaf.blog.models.role.Role;
import dev.bykowskiolaf.blog.models.user.User;
import dev.bykowskiolaf.blog.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Admin {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void addAdmin() {
        if (userRepository.count() > 0) return;
        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setRole(Role.ADMIN);
        user.setEmail("admin@example.com");
        user.setFirstName("Admin");
        user.setLastName("Admin");

        userRepository.save(user);
    }

}