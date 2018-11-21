package blog.Blog.Controller;

import blog.Blog.DesignPattern_Impl.Factory.PostFactory;
import blog.Blog.Domain.Comment;
import blog.Blog.Domain.Dto.PostDto;
import blog.Blog.Domain.Post;
import blog.Blog.Domain.User;
import blog.Blog.Service.PostService;
import blog.Blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @GetMapping(value = "/user/add")
    public String addG(Model model) {
        model.addAttribute("post", new Post());
        return "/user/addPost";
    }

    @PostMapping(value = "/user/add")
    public String addP(@ModelAttribute("post") @Valid PostDto postDto, BindingResult result,
                       Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        Post post = PostFactory.getInstance().createPostFromDto(postDto);

        post.setUser(user);
        post.setAutor(user.getName());
        if (result.hasErrors()) {
            model.addAttribute("error", result.getAllErrors());
            model.addAttribute("post", post);
            return "user/addPost";
        }

        postService.savePost(post);
        return "redirect:/post/"+ post.getId();
    }


    /*@PostMapping(value = "/post/edit")
    public String edit1(@ModelAttribute("post") PostDto postDto, BindingResult result,
                        Model model) {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("post", CreatedPost);
            return "user/edit";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        Post CreatedPost = PostFactory.getInstance().createPostFromDto(postDto);

        CreatedPost.setUser(user);
        System.out.println("-----------00000000000000000000000000000000000" + user);
        CreatedPost.setAutor(user.getName());
      //  postService.savePost(post);
        postService.update(CreatedPost);
        System.out.println("------------------------------------------3333333333333333333333333333333----" + CreatedPost.getId()+"-----"+postDto.getDate());

        return "redirect:/post/" + CreatedPost.getId();

    }*/

    @PostMapping(value = "/post/edit")
    public String editPost(@ModelAttribute("post") Post post, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("post", post);
            return "user/edit";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        /*if(!(user.getEmail().equals(post.equals(post.getUser().getEmail())))){
            return "redirect:/errors/403";
        }*/
        post.setAutor(user.getName());
        postService.update(post);
        return "redirect:/post/" + post.getId();
    }


    @GetMapping(value = "/post/{id}")
    public String getById(@PathVariable long id, Model model) {
        Post post = postService.getpostById(id);
        model.addAttribute("post", post);
        model.addAttribute("comment", new Comment());
        return "user/detail";
    }

    /*
    *
    * check if the user is the same with the post owner
    * if yes let him edit
    * otherwise should redirect him to access denied page 403 error
    *
    * */
    @GetMapping(value = "/post/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Post post = postService.getpostById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        if(!(post.getUser().getEmail().equals(user.getEmail()))){
            return "redirect:/errors/403";
        }

        if (post != null) {
            model.addAttribute("post", post);
            return "user/edit";
        }

        return "home";
    }


}
