package com.gcu.preach.Business;


import com.gcu.preach.dao.BlogRepository;
import com.gcu.preach.dao.UserBlogRepository;
import com.gcu.preach.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.gcu.preach.Business.UserBusinessService.userName;


public class BlogPostsBusinessService implements BlogPostsBusinessInterface {
public static List<BlogPost> blogPosts = new ArrayList<>();

    @Autowired
    private BlogRepository service;

    @Autowired
    private UserBlogRepository userService;

    //App Blog Posts
    @Override
    public List<BlogPost> getAllBlogPosts() {
        return service.getAllBlogPosts();
    }
    @Override
    public void createBlogPosts(BlogPost blogPost) {
        service.createBlogPosts(blogPost);

    }

    @Override
    public void updateBlogPosts(BlogPost blogPost) {
        service.updateBlogPosts(blogPost);

    }

    @Override
    public void deleteBlogPosts(int id) {
        service.deleteBlogPosts(id);

    }

    @Override
    public BlogPost getBlogPostById(int id) {
        return service.getBlogPostById(id);
    }

    @Override
    public void addBlogPost(BlogPost blogPost) {
        blogPosts.add(blogPost);
    }

    @Override
    public int getNextBlogId() {
        return service.GetNextBlogPostId();
    }




    // User Blog Posts
    @Override
    public void createUserBlogPosts(BlogPost blogPost) {
        userService.createUserBlogPosts(blogPost);
        userService.getAllUserBlogPosts(userName);
    }

    @Override
    public void updateUserBlogPosts(BlogPost blogPost) {
        userService.updateUserBlogPosts(blogPost);

    }

    @Override
    public void deleteUserBlogPosts(int id) {
        userService.deleteUserBlogPosts(id);
        userService.getAllUserBlogPosts(userName);
    }

    @Override
    public List<BlogPost> getAllUserBlogPosts() {
        return userService.getAllUserBlogPosts(userName);
    }

    @Override
    public void addUserBlogPost(BlogPost blogPost) {
        blogPosts.add(blogPost);
    }

    @Override
    public int getNextUserBlogId() {
        return userService.GetNextUserBlogPostId();
    }




}
