package com.gcu.preach.Business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Bean(name = "blogPostsBusinessService")
    BlogPostsBusinessService getBlogPostService() {
        return new BlogPostsBusinessService();
    }

}

