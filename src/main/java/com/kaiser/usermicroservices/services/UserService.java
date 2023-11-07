package com.kaiser.usermicroservices.services;

import com.kaiser.usermicroservices.entities.User;
import com.kaiser.usermicroservices.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@AllArgsConstructor
public class UserService {
    final private UserRepository userRepository;

    public User createUser(User user){
        if(user != null){
            userRepository.save(user);
            return user;
        }
        return null;
    }

    public User getUserById(int userId){
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(User user, int userId){
        Optional<User> userToModify = userRepository.findById(userId);
        if(userToModify.isPresent()){
            User existingUser = userToModify.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setBirthDate(user.getBirthDate());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhoneNumber(user.getPhoneNumber());

            userRepository.save(existingUser);
            return existingUser;
        } else {
            return null;
        }
    }

    public boolean deleteUser(int userId){
        Optional<User> userToDelete = userRepository.findById(userId);
        if(userToDelete.isPresent()){
            userRepository.delete(userToDelete.get());
            return true;
        } else {
            return false;
        }
    }
}
