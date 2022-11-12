package com.mak.trainingapi.repository;

import com.mak.trainingapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByLogin(String login);

    ArrayList<User> findAll();
}
