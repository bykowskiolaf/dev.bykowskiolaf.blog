package dev.bykowskiolaf.blog.models.post;

import dev.bykowskiolaf.blog.models.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, updatable = false)
    private UUID uuid;

    @NonNull
    private String title;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant creationDate;

    @NonNull
    @ManyToOne
    private User creator;

}
