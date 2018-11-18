package blog.Blog.Repository;

import blog.Blog.Domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {


    @Query("select p from Post p where flag=2")
    List<Post> findAllAfterApprovl();
}
