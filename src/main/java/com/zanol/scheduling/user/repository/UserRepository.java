package com.zanol.scheduling.user.repository;

import com.zanol.scheduling.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}