package com.mak.trainingapi.repository;

import com.mak.trainingapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    default User getUserByUsername(String username){
        Optional<User> user = findByUsername(username);
        if(user.isEmpty() || !user.get().isEnabled()){
            throw new UsernameNotFoundException("Username not found");
        }
        return user.get();
    }

    ArrayList<User> findAll();
}
