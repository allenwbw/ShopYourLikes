package com.ucla.shopyourlikes.repository;

import com.ucla.shopyourlikes.model.Role;
import com.ucla.shopyourlikes.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *  RoleRepository that provides client to find the Role
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     *
     * @param rolename
     * @return Role that matches the param
     */
    Optional<Role> findByName(RoleName rolename);

}
