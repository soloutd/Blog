package blog.Blog.Service;

import blog.Blog.Domain.User;

public interface UserService {

    void saveuser(User user);
    User getUserById(long id);
}
