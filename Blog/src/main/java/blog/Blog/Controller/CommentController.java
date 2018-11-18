package blog.Blog.Controller;

import blog.Blog.Domain.Comment;
import blog.Blog.Domain.Post;
import blog.Blog.Service.CommentService;
import blog.Blog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;



@Controller
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    PostService postService;

    @PostMapping(value = "/{id}")
    public String com(@PathVariable long id, @ModelAttribute("comment")Comment comment){

        Post post = postService.getpostById(id);
        post.addComment(comment);
        comment.setPost(post);

        postService.update(post);

        return "redirect:/post/"+post.getId();
    }

}
