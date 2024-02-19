package dev.bykowskiolaf.blog.controller;

import dev.bykowskiolaf.blog.model.Post;
import dev.bykowskiolaf.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Void> savePost(Post post) {
        postService.savePost(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
