package com.interviewprep.blindcs.post;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() { return postRepository.findAll(); }

    public void addNewPost(Post post) {
        // check if valid user
        postRepository.save(post);
    }

    public void
}
