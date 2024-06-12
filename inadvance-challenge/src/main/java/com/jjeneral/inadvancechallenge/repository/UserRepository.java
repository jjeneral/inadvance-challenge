package com.jjeneral.inadvancechallenge.repository;

import com.jjeneral.inadvancechallenge.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}