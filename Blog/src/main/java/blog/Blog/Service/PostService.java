package blog.Blog.Service;


import blog.Blog.Domain.Post;

import java.util.List;

public interface PostService {

    void savePost(Post post);
    void update(Post post);
    List<Post> getpostlistafterAproval();
    Post getpostById(long id);
    void deleteById(long id);
}
