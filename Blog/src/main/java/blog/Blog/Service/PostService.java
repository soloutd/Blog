package blog.Blog.Service;


import blog.Blog.Domain.Post;

import java.util.List;

public interface PostService {

    void savePost(Post post);
    void update(Post post);
    List<Post> getpostlistafterAproval();
    List<Post> getAllPosts();
    List<Post> getAllPosts_on_pending();
    Post getpostById(long id);
    void deleteById(long id);
   // void delete(Post post);
}
