package blog.Blog.Service.ServiceImpl;

import blog.Blog.Domain.User;
import blog.Blog.Repository.UserRepository;
import blog.Blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveuser(User user) {

        userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {

        return userRepository.getOne(id);
    }
}
