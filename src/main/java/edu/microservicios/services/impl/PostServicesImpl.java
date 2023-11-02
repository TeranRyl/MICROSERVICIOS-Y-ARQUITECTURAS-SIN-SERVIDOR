package edu.microservicios.services.impl;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import edu.microservicios.entity.Post;
import edu.microservicios.services.PostServices;
import org.bson.Document;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class PostServicesImpl implements PostServices {

    @Inject
    MongoClient mongoClient;


    @Override
    public List<Post> getAllPosts() {
        List<Post> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Post post = new Post();
                post.setId(String.valueOf(document.getObjectId("_id")));
                post.setMessage(document.getString("message"));
                post.setUser(document.getString("user"));
                list.add(post);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    

    @Override
    public void createPost(Post post) {
        Document document = new Document()
                .append("message", post.getMessage())
                .append("user", post.getUser());
        getCollection().insertOne(document);
    }



    @Override
    public List<String> getPostsIds(String user, String post) {
        List<Post> posts = getPostsByUser(user);
        List<String> postsIds = new ArrayList<>();
        for (Post t:posts){
            postsIds.add(t.getId().toString());
        }
        return postsIds;
    }
    
    
    @Override
    public List<Post> getPostsByUser(String user) {
        List<Post> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                if(Objects.equals(document.getString("user"), user)) {
                    Post post = new Post();
                    post.setId(String.valueOf(document.getObjectId("_id")));
                    post.setMessage(document.getString("message"));
                    post.setUser(document.getString("user"));
                    list.add(post);
                }
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("arepquarkus").getCollection("posts");
    }


}
