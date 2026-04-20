package com.example.demo.controller;

import com.example.demo.entity.BlogPost;
import com.example.demo.service.BlogPostService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {
    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }
    @GetMapping
    public List<BlogPost> getPost(){
        return blogPostService.getAllPosts();
    }
    @PostMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public BlogPost addPost(@RequestBody BlogPost post){
        return blogPostService.addPost(post);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public BlogPost updatePost(@PathVariable Long id,@RequestBody BlogPost post){
        return blogPostService.updatePost(id,post);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deletePost(@PathVariable Long id) {
        blogPostService.deletePost(id);
    }
}
