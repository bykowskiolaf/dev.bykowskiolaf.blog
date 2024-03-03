package dev.bykowskiolaf.blog.controllers;

import dev.bykowskiolaf.blog.dto.PostRequest;
import dev.bykowskiolaf.blog.dto.PostResponse;
import dev.bykowskiolaf.blog.models.post.Post;
import dev.bykowskiolaf.blog.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public Post savePost(@RequestBody PostRequest postRequest) {
        return postService.savePost(postRequest);
    }

}
