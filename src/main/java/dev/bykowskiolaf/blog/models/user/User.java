package dev.bykowskiolaf.blog.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.bykowskiolaf.blog.models.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;
import java.util.UUID;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, updatable = false)
    private UUID uuid;

    @NonNull
    @Size(min = 3, max = 255)
    @Email
    @Column(unique = true)
    private String email;

    @NonNull
    @Size(min = 3, max = 127)
    private String username;

    @NonNull
    @Size(min = 1, max = 255)
    private String firstName;

    @NonNull
    @Size(min = 1, max = 255)
    private String lastName;

    @NonNull
    @Size(min = 8, max = 255)
    @JsonIgnore
    private String password;

    @CreationTimestamp
    private Instant creationDate;

    private boolean enabled = true;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
