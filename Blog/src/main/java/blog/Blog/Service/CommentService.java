package blog.Blog.Service;

import blog.Blog.Domain.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> getAllComments();
    public Comment getComment(long id);
    public void addComment(Comment comment);
}
