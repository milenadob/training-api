package com.mak.trainingapi.repository;

import com.mak.trainingapi.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(String roleName);
}
