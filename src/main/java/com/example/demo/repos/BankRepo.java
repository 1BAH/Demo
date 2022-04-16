package com.example.demo.repos;

import com.example.demo.models.Bank;
import com.example.demo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface BankRepo extends CrudRepository<Bank, Long> {
}
