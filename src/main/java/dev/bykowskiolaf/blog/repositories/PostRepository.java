package dev.bykowskiolaf.blog.repositories;


import dev.bykowskiolaf.blog.models.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByUuid(UUID uuid);
    void deleteByUuid(UUID uuid);
}
