package dev.bykowskiolaf.blog.services;

import dev.bykowskiolaf.blog.dto.PostRequest;
import dev.bykowskiolaf.blog.dto.PostResponse;
import dev.bykowskiolaf.blog.models.post.Post;
import dev.bykowskiolaf.blog.models.user.User;
import dev.bykowskiolaf.blog.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post savePost(PostRequest postRequest) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = new Post(postRequest.title(), user);
        return postRepository.save(post);
    }

    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream().map( post ->
                new PostResponse(
                        post.getUuid(),
                        post.getTitle(),
                        post.getCreationDate(),
                        post.getCreator().getUuid())).toList();
    }

    public void deletePost(String uuid) {
        postRepository.deleteByUuid(UUID.fromString(uuid));
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

}
