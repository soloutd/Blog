package blog.Blog.Controller;

import blog.Blog.Domain.Comment;
import blog.Blog.Domain.Post;
import blog.Blog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    PostService postService;

    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    public String home(Model model){

        model.addAttribute("posts",postService.getAllPosts());
       // System.out.println(postService.getpostlistafterAproval().toString());
        return "admin/home";
    }

    @RequestMapping(value = {"/pending"},method = RequestMethod.GET)
    public String pending(Model model){
        model.addAttribute("posts",postService.getAllPosts_on_pending());
        return "admin/home";
    }

    @GetMapping(value = "/req/{id}")
    public String req(@PathVariable long id, Model model){

        Post post = postService.getpostById(id);
        model.addAttribute("post", post);
       // model.addAttribute("comment", new Comment());
        return "admin/detail";
       /* return "admin/home";*/
    }

  @GetMapping(value = "/edit/{id}")
    public String adminedit(@PathVariable long id){

        Post post1 = postService.getpostById(id);
        post1.setFlag("Approved");
        postService.update(post1);
        return "redirect:/home";
  }

    @GetMapping(value = "/delete/{id}")
    public String admindelet(@PathVariable long id){

        //Post post1 = postService.getpostById(id);
       // post1.setFlag("Delete");
        postService.deleteById(id);
        return "redirect:/home";
    }

}
