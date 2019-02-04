package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.Role;
import com.arefin.sunshinefarm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
