package com.quotech.quotechusers.repositories;

import com.quotech.quotechusers.models.User;
import com.quotech.quotechusers.models.UserId;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UserId> {

}
