package dev.bykowskiolaf.blog.repository;


import dev.bykowskiolaf.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByTitle(String title);

    void deleteByUuid(String uuid);
}
