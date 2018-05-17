package com.ucla.shopyourlikes.repository;
import com.ucla.shopyourlikes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    User findByUserId(Integer userId);

    boolean existsByUserIdAndAndApiKey(Integer userId, String apiKey);
}
