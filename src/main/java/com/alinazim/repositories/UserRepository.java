package com.alinazim.repositories;

import com.alinazim.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);

    User findTopByUsername(String username);

    User findTopByPassword(String password);
}
