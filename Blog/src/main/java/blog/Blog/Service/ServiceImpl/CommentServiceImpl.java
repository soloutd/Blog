package blog.Blog.Service.ServiceImpl;

import blog.Blog.Domain.Comment;
import blog.Blog.Repository.CommentRepository;
import blog.Blog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getComment(long id) {
        return commentRepository.getOne(id);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }
}
