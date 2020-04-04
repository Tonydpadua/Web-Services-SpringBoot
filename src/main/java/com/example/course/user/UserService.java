package com.example.course.user;


import com.example.course.exceptions.DatabaseException;
import com.example.course.exceptions.RestControllerNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RestControllerNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RestControllerNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        try {
            User user1 = userRepository.getOne(id);
            updateData(user1, user);
            return userRepository.save(user1);
        } catch (EntityNotFoundException e) {
            throw new RestControllerNotFoundException(id);
        }
    }


    public void updateData(User user,User user1){
        user.setName(user1.getName());
        user.setEmail(user1.getEmail());
        user.setPhone(user1.getPhone());
    }

}
