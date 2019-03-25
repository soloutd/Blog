package blog.Blog.RestFul;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class GameOfThroneController {

    private List<Solider> soliderlist = new ArrayList<>(Arrays.asList(new Solider("jhon Snow", 123),new Solider("janous",321)));
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String hello(@RequestParam(defaultValue = "stranger")String name){
        return "hello "+name+" do you pledge your life to the night watch!";
    }
    @RequestMapping(value = "/solider", method = RequestMethod.GET)
    public List<Solider> list(){
        return soliderlist;
    }

    @RequestMapping(value = "/new1", method = RequestMethod.POST)
    private Solider newone(@RequestBody Solider solider){
        soliderlist.add(solider);
        return solider;
    }
}
