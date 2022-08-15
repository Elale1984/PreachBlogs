package com.gcu.preach.dao;


import com.gcu.preach.entity.BlogPost;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BlogRepository {
    void createBlogPosts(BlogPost blogPost);
    void updateBlogPosts(BlogPost blogPost);
    void deleteBlogPosts(int id);
    BlogPost getBlogPostById(int id);
    List<BlogPost> getAllBlogPosts();

    int GetNextBlogPostId();
}
