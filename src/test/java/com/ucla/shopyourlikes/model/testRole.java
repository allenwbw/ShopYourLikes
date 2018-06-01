package com.ucla.shopyourlikes.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testRole {

    private Role role;

    @Before
    public void setUp() {
        this.role = new Role();
    }

    @Test
    public void testRoleObjCreation() {
        role.setId(100);
        RoleName roleName = RoleName.ROLE_ADMIN;
        role.setName(roleName);

        assertEquals(new Integer(100),role.getId());
        assertEquals(RoleName.ROLE_ADMIN,role.getName());

    }

}
