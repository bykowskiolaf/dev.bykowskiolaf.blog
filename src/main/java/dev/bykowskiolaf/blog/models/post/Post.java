package dev.bykowskiolaf.blog.models.post;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Table(name = "posts")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    @NotNull
    @Column(unique = true)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String uuid;

    @NotNull
    private String title;

    @CreationTimestamp
    @NotNull
    private Instant creationDate;

    public Post(String title) {
        this.title = title;
        this.uuid = String.valueOf(UUID.randomUUID());
    }
}
