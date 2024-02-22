package dev.bykowskiolaf.blog.services;

import dev.bykowskiolaf.blog.models.post.Post;
import dev.bykowskiolaf.blog.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void deletePost(String uuid) {
        postRepository.deleteByUuid(uuid);
    }

    public void updatePost(Post post) {
        postRepository.save(post);
    }

    public Post getPostByTitle(String title) {
        return postRepository.findByTitle(title);
    }


}
