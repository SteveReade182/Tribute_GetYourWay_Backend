package com.sky.getyourway.data.repository;

import com.sky.getyourway.data.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
