package blog.Blog.Service.ServiceImpl;

import blog.Blog.Domain.Post;
import blog.Blog.Repository.PostRepository;
import blog.Blog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    public PostServiceImpl() {
    }

    @Override
    public void savePost(Post post) {
        post.setDate(new Date());
        post.setFlag("Pending");
        postRepository.save(post);
    }

    @Override
    public void update(Post post) {
        /*Post post1 = getpostById(id);
        post.setDate(post1.getDate());*/

        if(post.getFlag()!="approved"){
            post.setFlag("approved");
            postRepository.save(post);
        }else {
            post.setDate(new Date());
            //  post.setFlag("approved");

            postRepository.save(post);
        }
        }



    @Override
    public List<Post> getpostlistafterAproval() {

        return postRepository.findAllAfterApprovl();
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getAllPosts_on_pending() {
        return postRepository.findallonPending();
    }

    @Override
    public Post getpostById(long id) {

        return postRepository.getOne(id);
    }

    @Override
    public void deleteById(long id) {
        Post post = postRepository.getOne(id);
        post.setFlag("Deleted");
        postRepository.save(post);
    }
}
