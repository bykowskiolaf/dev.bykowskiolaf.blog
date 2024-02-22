package dev.bykowskiolaf.blog.models.role;

import dev.bykowskiolaf.blog.models.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Table(name = "roles")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue
    @NotNull
    @Column(unique = true)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Roles name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @Override
    public String getAuthority() {
        return name.name();
    }
}
