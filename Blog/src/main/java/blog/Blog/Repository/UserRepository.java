package blog.Blog.Repository;

import blog.Blog.Domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User, Long> {


    User findUserByEmail(String email);

}
