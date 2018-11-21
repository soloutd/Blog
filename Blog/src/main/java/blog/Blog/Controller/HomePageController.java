package blog.Blog.Controller;

import blog.Blog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomePageController {

    @Autowired
    PostService postService;

    @RequestMapping(value = {"/","/home","/blog","/blog/home"},method = RequestMethod.GET)
    public String home(Model model){

        model.addAttribute("posts",postService.getpostlistafterAproval());
        System.out.println(postService.getpostlistafterAproval().toString());
        return "home";
    }

    @GetMapping(value = "/errors/403")
    public String error(){

        return "/403/index";
    }

    @GetMapping(value = "/error")
    public String error1(){

        return "redirect:/blog/home";
    }

   /* @GetMapping(value = "/search")
    public String search(@RequestParam("search") String s,Model model){
        postService.
    }*/
    
}
