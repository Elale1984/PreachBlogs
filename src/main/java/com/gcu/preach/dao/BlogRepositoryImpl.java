package com.gcu.preach.dao;

import com.gcu.preach.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;


@Repository
public class BlogRepositoryImpl implements BlogRepository, UserBlogRepository {


    //User Blog Posts
    private static final String INSERT_USER_BLOG_POST_QUERY = "INSERT INTO userblogpost(id, title, contentPreview, fullContent, author, date, likes) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_USER_BLOG_POST_BY_ID_QUERY = "SELECT * FROM userblogpost WHERE id=?";
    private static final String GET_ALL_USER_BLOG_POSTS_QUERY = "SELECT * FROM userblogpost WHERE author=?";
    private static final String GET_NEXT_USER_BLOG_POST_ID_QUERY = "SELECT MAX(id) FROM userblogpost";
    private static final String UPDATE_USER_BLOG_POST_BY_ID_QUERY = "UPDATE userblogpost SET title=?, contentPreview=?, fullContent=?, author=?, date=?, likes=? WHERE id=?";
    private static final String DELETE_USER_BLOG_POST_BY_ID_QUERY = "DELETE FROM userblogpost WHERE id=?";


    //All Blog Posts
    private static final String INSERT_BLOG_POST_QUERY = "INSERT INTO blogpost(id, title, contentPreview, fullContent, author, date, likes) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_BLOG_POST_BY_ID_QUERY = "SELECT * FROM blogpost WHERE id=?";
    private static final String GET_ALL_BLOG_POSTS_QUERY = "SELECT * FROM blogpost";
    private static final String GET_NEXT_BLOG_POST_ID_QUERY = "SELECT MAX(id) FROM blogpost";
    private static final String UPDATE_BLOG_POST_BY_ID_QUERY = "UPDATE blogpost SET title=?, contentPreview=?, fullContent=?, author=?, date=?, likes=? WHERE id=?";
    private static final String DELETE_BLOG_POST_BY_ID_QUERY = "DELETE FROM blogpost WHERE id=?";

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //App Blog Posts Crude Methods
    @Override
    public void createBlogPosts(BlogPost blogPost) {
        jdbcTemplate.update(INSERT_BLOG_POST_QUERY, blogPost.getId(), blogPost.getTitle(),
                blogPost.getContentPreview(), blogPost.getFullContent(), blogPost.getAuthor(),
                blogPost.getDate(), blogPost.getLikes());
    }

    @Override
    public void updateBlogPosts(BlogPost blogPost) {
        jdbcTemplate.update(UPDATE_BLOG_POST_BY_ID_QUERY, blogPost.getTitle(),
                blogPost.getContentPreview(), blogPost.getFullContent(), blogPost.getAuthor(),
                blogPost.getDate(), blogPost.getId(), blogPost.getLikes());
    }

    @Override
    public void deleteBlogPosts(int id) {
        jdbcTemplate.update(DELETE_BLOG_POST_BY_ID_QUERY, id);
    }

    @Override
    public BlogPost getBlogPostById(int id) {
        return jdbcTemplate.queryForObject(GET_BLOG_POST_BY_ID_QUERY, (rs, rowNum) -> new BlogPost(
                rs.getInt("id"), rs.getString("title"),
                rs.getString("contentPreview"), rs.getString("fullContent"),
                rs.getString("author"), rs.getString("date"), rs.getInt("likes")), id);
    }

    @Override
    public List<BlogPost> getAllBlogPosts() {
        return jdbcTemplate.query(GET_ALL_BLOG_POSTS_QUERY, (rs, rowNum) -> new BlogPost(
                rs.getInt("id"), rs.getString("title"),
                rs.getString("contentPreview"), rs.getString("fullContent"),
                rs.getString("author"), rs.getString("date"), rs.getInt("likes")));
    }

    @Override
    public int GetNextBlogPostId() {
        if(jdbcTemplate.queryForObject(GET_NEXT_BLOG_POST_ID_QUERY, Integer.class) == null) {
            return 0;
        }
        else {
            return jdbcTemplate.queryForObject(GET_NEXT_BLOG_POST_ID_QUERY, Integer.class) + 1;
        }
    }

    //User Blog Posts Crude Methods

    @Override
    public void createUserBlogPosts(BlogPost blogPost) {
        jdbcTemplate.update(INSERT_USER_BLOG_POST_QUERY, blogPost.getId(), blogPost.getTitle(),
                blogPost.getContentPreview(), blogPost.getFullContent(), blogPost.getAuthor(),
                blogPost.getDate(), blogPost.getLikes());
    }

    @Override
    public void updateUserBlogPosts(BlogPost blogPost) {
        jdbcTemplate.update(UPDATE_USER_BLOG_POST_BY_ID_QUERY, blogPost.getTitle(),
                blogPost.getContentPreview(), blogPost.getFullContent(), blogPost.getAuthor(),
                blogPost.getDate(), blogPost.getId(), blogPost.getLikes());
    }

    @Override
    public void deleteUserBlogPosts(int id) {
        jdbcTemplate.update(DELETE_USER_BLOG_POST_BY_ID_QUERY, id);
    }

    @Override
    public BlogPost getUserBlogPostById(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BLOG_POST_BY_ID_QUERY, (rs, rowNum) -> new BlogPost(
                rs.getInt("id"), rs.getString("title"),
                rs.getString("contentPreview"), rs.getString("fullContent"),
                rs.getString("author"), rs.getString("date"), rs.getInt("likes")), id);
    }

    @Override
    public List<BlogPost> getAllUserBlogPosts(String username) {

            return jdbcTemplate.query(GET_ALL_USER_BLOG_POSTS_QUERY, (rs, rowNum) -> new BlogPost(
                    rs.getInt("id"), rs.getString("title"),
                    rs.getString("contentPreview"), rs.getString("fullContent"),
                    rs.getString("author"), rs.getString("date"), rs.getInt("likes")), username);


    }

    @Override
    public int GetNextUserBlogPostId() {
        if(jdbcTemplate.queryForObject(GET_NEXT_USER_BLOG_POST_ID_QUERY, Integer.class) == null) {
            return 0;
        }
        else {
            return jdbcTemplate.queryForObject(GET_NEXT_USER_BLOG_POST_ID_QUERY, Integer.class) + 1;
        }
    }






}

