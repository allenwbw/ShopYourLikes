package com.ucla.shopyourlikes.repository;

import com.ucla.shopyourlikes.model.LinkId;
import com.ucla.shopyourlikes.model.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
 *  LinkRepository that provides user access to find the link
 */
@Repository
public interface LinkRepository extends JpaRepository<Link, LinkId> {

    /**
     *
     * @param userId
     * @param pageable
     * @return a list page of Link for the param
     */
    Page<Link> findByLinkIdUserId(Integer userId, Pageable pageable);

    /**
     *
     * @param linkId
     * @return the link with the param
     */
    Optional<Link> findByLinkId(LinkId linkId);

    /**
     *
     * @param userId
     * @return the count of the link by UserId
     */
    long countByLinkIdUserId(Integer userId);

}
