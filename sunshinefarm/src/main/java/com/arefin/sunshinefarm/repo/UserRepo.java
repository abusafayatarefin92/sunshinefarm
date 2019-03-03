package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.Role;
import com.arefin.sunshinefarm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public Optional<User> findByUsernameOrEmail(String username, String email);
    User findByUserName(String username);

}
