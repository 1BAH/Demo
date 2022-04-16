package com.example.demo.repos;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByName(String name);
}
