package com.bank.blog_api.repository;

import com.bank.blog_api.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

}
