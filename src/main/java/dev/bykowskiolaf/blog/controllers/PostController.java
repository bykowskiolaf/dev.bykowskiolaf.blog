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

    @DeleteMapping("/{uuid}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT) TODO: Fix this
    public void deletePost(@PathVariable String uuid) {
        postService.deletePost(uuid);
    }

    @PutMapping("/{uuid}")
    public Post updatePost(@RequestBody PostRequest postRequest, @PathVariable String uuid) {
        return postService.updatePost(postRequest, uuid);
    }
}
