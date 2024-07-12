package com.bank.blog_api.controller;

import com.bank.blog_api.controlleradvice.ResourceNotFoundException;
import com.bank.blog_api.entity.BlogPost;
import com.bank.blog_api.repository.BlogPostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/blog-posts")
public class BlogPostController {
    private final BlogPostRepository blogPostRepository;

    public BlogPostController(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostRepository.findAll();
        return ResponseEntity.ok(blogPosts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog post not found with id: " + id));
        return ResponseEntity.ok(blogPost);
    }

    @PostMapping("/create")
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        blogPost.setCreatedat(LocalDateTime.now());
        blogPost.setUpdatedat(LocalDateTime.now());
        BlogPost savedBlogPost = blogPostRepository.save(blogPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBlogPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPost) {
        BlogPost existingBlogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog post not found with id: " + id));
        existingBlogPost.setTitle(blogPost.getTitle());
        existingBlogPost.setContent(blogPost.getContent());
        existingBlogPost.setUpdatedat(LocalDateTime.now());
        BlogPost updatedBlogPost = blogPostRepository.save(existingBlogPost);
        return ResponseEntity.ok(updatedBlogPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog post not found with id: " + id));
        blogPostRepository.delete(blogPost);
        return ResponseEntity.noContent().build();
    }
}