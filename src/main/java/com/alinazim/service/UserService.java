package com.alinazim.service;

import com.alinazim.entitiy.User;
import com.alinazim.repositories.CourseRepository;
import com.alinazim.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(User user) {
        System.out.println("Service GET *****");
        return userRepository.findByUsernameAndPassword(user.getPassword(), user.getPassword());
    }

    public boolean getUserByUsername(String username, String password) {
        boolean usernamePresent;
        boolean passwordPresent;

        try {
            usernamePresent = userRepository.findTopByUsername(username) != null ? true : false;
            System.out.printf("Username present: " + usernamePresent);

            passwordPresent = userRepository.findTopByPassword(password) != null ? true : false;
            System.out.printf("Password present: " + passwordPresent);
        } catch (NonUniqueResultException nre) {
            return true;
        }
        return usernamePresent && passwordPresent;
    }

    public boolean findUserByUsername(String username) {
        boolean usernamePresent;

        try {
            usernamePresent = userRepository.findTopByUsername(username) != null ? true : false;
            System.out.printf("Username present: " + usernamePresent);
        } catch (NonUniqueResultException nre) {
            return true;
        }
        return usernamePresent;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
