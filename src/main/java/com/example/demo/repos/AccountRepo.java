package com.example.demo.repos;

import com.example.demo.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Long> {

}
