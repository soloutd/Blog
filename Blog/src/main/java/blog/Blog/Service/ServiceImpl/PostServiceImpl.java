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
        post.setFlag("2");
        postRepository.save(post);
    }

    @Override
    public void update(Post post) {
        /*Post post1 = getpostById(id);
        post.setDate(post1.getDate());*/
        post.setDate(new Date());
        post.setFlag("2");
        postRepository.save(post);
    }


    @Override
    public List<Post> getpostlistafterAproval() {

        return postRepository.findAllAfterApprovl();
    }

    @Override
    public Post getpostById(long id) {

        return postRepository.getOne(id);
    }

    @Override
    public void deleteById(long id) {
        Post post = postRepository.getOne(id);
        post.setFlag("0");
        postRepository.save(post);
    }
}
