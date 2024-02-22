package dev.bykowskiolaf.blog.models.user;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;

@Table(name = "users")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  implements UserDetails {

    @Id
    @GeneratedValue
    @NotNull
    @Column(unique = true)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String uuid;

    @NotNull
    @Size(min = 3, max = 255)
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min = 3, max = 127)
    private String username;

    @NotNull
    @Size(min = 1, max = 255)
    private String firstName;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<> roles;

    @NotNull
    @Size(min = 1, max = 255)
    private String lastName;

    private String password;

    @CreationTimestamp
    private Instant creationDate;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return ;
    }

}
