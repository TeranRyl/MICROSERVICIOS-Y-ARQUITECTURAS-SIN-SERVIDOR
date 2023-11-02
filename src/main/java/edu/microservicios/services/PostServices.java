package edu.microservicios.services;

import edu.microservicios.entity.Post;

import java.util.List;

public interface PostServices {

    List<Post> getAllPosts();

    List<Post> getPostsByUser(String user);

    void createPost(Post post);

    List<String> getPostsIds(String user, String post);
}
