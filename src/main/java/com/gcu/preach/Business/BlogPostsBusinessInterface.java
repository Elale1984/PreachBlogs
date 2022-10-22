package com.gcu.preach.Business;

import com.gcu.preach.entity.BlogPost;

import java.util.List;

public interface BlogPostsBusinessInterface {
    void createBlogPosts(BlogPost blogPost);
    void updateBlogPosts(BlogPost blogPost);
    void deleteBlogPosts(int id);
    BlogPost getBlogPostById(int id);
    List<BlogPost> getAllBlogPosts();
    void addBlogPost(BlogPost blogPost);
    int getNextBlogId();


    void createUserBlogPosts(BlogPost blogPost);
    void updateUserBlogPosts(BlogPost blogPost);
    void deleteUserBlogPosts(int id);
    List<BlogPost> getAllUserBlogPosts();
    void addUserBlogPost(BlogPost blogPost);
    int getNextUserBlogId();


}
