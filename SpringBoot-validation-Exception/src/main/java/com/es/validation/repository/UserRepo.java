package com.es.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.es.validation.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
