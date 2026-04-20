package com.example.demo.service;

import com.example.demo.entity.BlogPost;
import com.example.demo.repository.BlogPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
    private final BlogPostRepository postRepository;

    public BlogPostService(BlogPostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<BlogPost> getAllPosts() {
        return postRepository.findAll();
    }

    public BlogPost addPost(BlogPost post) {
        return postRepository.save(post);
    }

    public BlogPost updatePost(Long id, BlogPost updatedPost) {
        return postRepository.findById(id).map(post -> {
            post.setTitle(updatedPost.getTitle());
            post.setPost(updatedPost.getPost());
            return postRepository.save(post);
        }).orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
