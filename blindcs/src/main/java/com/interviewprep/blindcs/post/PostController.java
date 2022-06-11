package com.interviewprep.blindcs.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts() { return postService.getPosts(); }

    @PostMapping
    public void createPost(@RequestBody Post post) { postService.addNewPost(post); }

    @PutMapping(path = "post/postId")
    public void updatePost(@PathVariable Long postId, string postText) {
        postService.upd
    }
}
