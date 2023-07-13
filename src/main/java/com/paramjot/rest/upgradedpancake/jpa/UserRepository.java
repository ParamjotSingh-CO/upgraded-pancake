package com.paramjot.rest.upgradedpancake.jpa;

import com.paramjot.rest.upgradedpancake.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
