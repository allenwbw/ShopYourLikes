package com.ucla.shopyourlikes.model;

import org.junit.Test;

public class testRoleName {
    private RoleName roleName;

    @Test
    public void testRoleNameObjCreation() {
        this.roleName = RoleName.ROLE_USER;
        this.roleName = RoleName.ROLE_ADMIN;
    }
}
