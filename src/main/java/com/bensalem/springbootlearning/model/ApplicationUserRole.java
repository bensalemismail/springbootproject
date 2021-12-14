package com.bensalem.springbootlearning.model;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<GrantedAuthority> getGrantedAuthorities(){
        Set<GrantedAuthority> collect = role.stream().map(
                applicationUserPermission -> new SimpleGrantedAuthority(applicationUserPermission.getPermission())
        ).collect(Collectors.toSet());
        collect.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return collect;
    }
}
