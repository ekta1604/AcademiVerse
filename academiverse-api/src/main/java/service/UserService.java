package service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public User saveUser (User User){
        User.setCreatedAt(LocalDateTime.now());
        User.setUpdatedAt(LocalDateTime.now());
        User savedUser = userRepository.save(User);

        log.info("User with id: {} saved successfully", User.getId());
        return savedUser;
    }

    public User updateUser (User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        user.setCreatedAt(existingUser.get().getCreatedAt());
        user.setUpdatedAt(LocalDateTime.now());

        User updatedUser = userRepository.save(user);

        return updatedUser;
    }

    public boolean deleteUserById (Integer id) {
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()){
            userRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
