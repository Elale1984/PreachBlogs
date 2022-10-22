package com.gcu.preach.controller;

import com.gcu.preach.Business.BlogPostsBusinessInterface;
import com.gcu.preach.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Struct;

@Controller
@RequestMapping("/fullpost")
public class FullPostController {
    private BlogPost blogPost;
    @Autowired
    private BlogPostsBusinessInterface blogPostsBusinessService;

    @GetMapping("/{id}")
    public String getPost(@PathVariable int id, Model model) {
        blogPost = blogPostsBusinessService.getBlogPostById(id);
        // Display Full Blog Post form view
        model.addAttribute("blogPost", blogPostsBusinessService.getBlogPostById(id));
        model.addAttribute("likes", blogPostsBusinessService.getBlogPostById(id).getLikes());
        return "fullpost";
    }

    @PostMapping("/doLikePost")
    public String doLikePost() {


        blogPost.setLikes(1);
        blogPost.setTitle("Bobs Day Out");
        blogPostsBusinessService.updateBlogPosts(blogPost);
        blogPostsBusinessService.updateBlogPosts(blogPost);
        return "redirect:/index/";

    }

}
