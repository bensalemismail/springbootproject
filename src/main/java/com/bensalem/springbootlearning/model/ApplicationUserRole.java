package com.bensalem.springbootlearning.model;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.bensalem.springbootlearning.model.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(CUSTOMER_UPDATE,CUSTOMER_READ,CUSTOMER_ADD,CUSTOMER_DELETE)),
    CUSTOMER(Sets.newHashSet(CUSTOMER_READ));

    private final Set<ApplicationUserPermission> role;

    ApplicationUserRole(Set<ApplicationUserPermission> role) {
        this.role = role;
    }

    public Set<ApplicationUserPermission> getRole() {
        return role;
    }
}
