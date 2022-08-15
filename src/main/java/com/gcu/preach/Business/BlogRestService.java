package com.gcu.preach.Business;


import com.gcu.preach.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")
public class BlogRestService {
	
	@Autowired
	BlogPostsBusinessService service;
	
	@GetMapping(path="/getallblogs", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<BlogPost> getOrdersAsJson(){
		return service.getAllBlogPosts();
	}
	

	
	@GetMapping(path="/getblog/{id}")
	public ResponseEntity<?> getOrder(@PathVariable("id") int id){
		try {
			BlogPost blog = service.getBlogPostById(id);
			if(blog == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(blog, HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
