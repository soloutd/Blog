/*
package blog.Blog.Repository.RepositoryImpl;

import blog.Blog.Domain.User;
import blog.Blog.Repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@DynamicUpdate
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void SaveUser(User user) {

        Session session;
        session = sessionFactory.getCurrentSession();
        session.save(user);
        session.flush();
    }
}
*/
