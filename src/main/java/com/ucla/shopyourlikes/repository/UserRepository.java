package com.ucla.shopyourlikes.repository;
import com.ucla.shopyourlikes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * UserRepository that provides client to find the user
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    /**
     *
     * @param userId
     * @return the user that matches param
     */
    User findByUserId(Integer userId);

    /**
     *
     * @param userId
     * @param apiKey
     * @return the user that matches the params
     */
    boolean existsByUserIdAndAndApiKey(Integer userId, String apiKey);
}
