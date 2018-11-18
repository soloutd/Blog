package blog.Blog.Controller;

import blog.Blog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class HomePageController {

    @Autowired
    PostService postService;

    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    public String home(Model model){

        model.addAttribute("posts",postService.getpostlistafterAproval());
        System.out.println(postService.getpostlistafterAproval().toString());
        return "home";
    }
    
}
