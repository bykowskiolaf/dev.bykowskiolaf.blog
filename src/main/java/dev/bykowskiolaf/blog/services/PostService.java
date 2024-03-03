package dev.bykowskiolaf.blog.services;

import dev.bykowskiolaf.blog.dto.PostRequest;
import dev.bykowskiolaf.blog.dto.PostResponse;
import dev.bykowskiolaf.blog.models.post.Post;
import dev.bykowskiolaf.blog.models.role.Role;
import dev.bykowskiolaf.blog.models.user.User;
import dev.bykowskiolaf.blog.repositories.PostRepository;
import jakarta.transaction.Transactional;
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

    public Post updatePost(PostRequest newPost, String postUuid) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("before found post");
        Post oldPost = postRepository.findByUuid(UUID.fromString(postUuid)).orElseThrow(
                () -> new RuntimeException("Post not found")
        );

        System.out.println("found post");

        if (oldPost.getCreator().getUuid().equals(user.getUuid()) || user.getRole() == Role.ADMIN ) {
            oldPost.setTitle(newPost.title());
            return postRepository.save(oldPost);
        } else {
            throw new RuntimeException("You are not the creator of this post");
        }
    }


    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream().map(post ->
                new PostResponse(
                        post.getUuid(),
                        post.getTitle(),
                        post.getCreationDate(),
                        post.getCreator().getUuid())).toList();
    }

    @Transactional
    public void deletePost(String uuid) {
        postRepository.deleteByUuid(UUID.fromString(uuid));
    }

}
