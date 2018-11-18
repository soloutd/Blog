package blog.Blog.Service;

import blog.Blog.Domain.User;

public interface UserService {


    User getUserById(long id);

    User findUserByEmail(String email);

    void saveUser(User user);
}
