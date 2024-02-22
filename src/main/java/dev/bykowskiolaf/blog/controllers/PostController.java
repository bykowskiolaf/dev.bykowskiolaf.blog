package dev.bykowskiolaf.blog.controllers;

import dev.bykowskiolaf.blog.models.post.Post;
import dev.bykowskiolaf.blog.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
    }

    @PostMapping
    public ResponseEntity<ResponseStatus> savePost(
            @RequestHeader("title") String title
    ) {
        postService.savePost(new Post(title));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
