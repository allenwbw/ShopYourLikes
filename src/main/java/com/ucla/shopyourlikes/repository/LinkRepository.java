package com.ucla.shopyourlikes.repository;

import com.ucla.shopyourlikes.model.LinkId;
import com.ucla.shopyourlikes.model.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface LinkRepository extends JpaRepository<Link, LinkId> {

    //@Query(value = "SELECT l FROM Link l WHERE l.userId = :userId AND l.lastUpdated > :timestamp")
    //List<Link> findByUserIdAndLastUpdatedAfter(@Param("userId") Integer userId, @Param("timestamp") Integer timestamp);
    List<Link> findByLinkId_UserIdAndLastUpdatedAfter(Integer userId, Integer timestamp);

}
