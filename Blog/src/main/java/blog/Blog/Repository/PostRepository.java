package blog.Blog.Repository;

import blog.Blog.Domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {


    @Query("select p from Post p where flag='approved'")
    List<Post> findAllAfterApprovl();

    @Query("select p from Post p where flag='Pending'")
    List<Post> findallonPending();

    @Query("select p from Post p where article=s")
    List<Post> searchbyArticle(String s);
}
