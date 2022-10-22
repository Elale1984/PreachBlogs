package com.gcu.preach.controller;


import com.gcu.preach.Business.BlogPostsBusinessInterface;
import com.gcu.preach.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.gcu.preach.Business.UserBusinessService.userName;
@Controller
@RequestMapping("/postBlog")
public class PostBlogController {

    @Autowired
    private BlogPostsBusinessInterface blogPostsBusinessService;

    @GetMapping("/")
    public String display(Model model) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        BlogPost blogPost = new BlogPost();
        blogPost.setId(blogPostsBusinessService.getNextBlogId());
        blogPost.setDate(strDate);
        blogPost.setAuthor(userName);
        blogPost.setLikes(0);
        // Display post blog form view
        model.addAttribute("headerText", "Preach It!!");
        model.addAttribute("blogPost", blogPost);
        model.addAttribute("userName", userName);


        return "postBlog";
    }

    @PostMapping("/doPost")
    public String doPost(@Valid BlogPost blogPost, BindingResult bindingresult, Model model) {
        if(bindingresult.hasErrors()) {
            model.addAttribute("headerText", "Preach It!!");
            return "postBlog";
        }
        else {
            //Save to blogposts table
            blogPostsBusinessService.createBlogPosts(blogPost);
            //save to userblogposts table
            blogPostsBusinessService.createUserBlogPosts(blogPost);
            return "redirect:/index/";
        }
    }

}
