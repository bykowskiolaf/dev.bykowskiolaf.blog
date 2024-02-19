package dev.bykowskiolaf.blog.service;

import dev.bykowskiolaf.blog.model.Post;
import dev.bykowskiolaf.blog.repository.PostRepository;
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
