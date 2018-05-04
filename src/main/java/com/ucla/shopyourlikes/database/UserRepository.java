package com.ucla.shopyourlikes.database;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    public User getUserByUsername(String username);

}
