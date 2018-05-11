package com.ucla.shopyourlikes.repository;
import com.ucla.shopyourlikes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUserId(Integer userId);

}
