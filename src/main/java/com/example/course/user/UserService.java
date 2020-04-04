package com.example.course.user;


import com.example.course.exceptions.RestControllerNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }


    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()-> new RestControllerNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User update(Long id,User user){
        User user1 = userRepository.getOne(id);
        updateData(user1,user);
        return userRepository.save(user1);
    }
    public void updateData(User user,User user1){
        user.setName(user1.getName());
        user.setEmail(user1.getEmail());
        user.setPhone(user1.getPhone());
    }

}
