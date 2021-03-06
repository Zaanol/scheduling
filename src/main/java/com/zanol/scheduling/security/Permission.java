package com.zanol.scheduling.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permission extends SecurityEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PermissionType permissionType;

    public Permission() {
    }

    public Permission(String code, String name, PermissionType permissionType) {
        super.setCode(code);
        super.setName(name);
        this.permissionType = permissionType;
    }

    public Long getId() {
        return id;
    }

    public PermissionType getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(PermissionType permissionType) {
        this.permissionType = permissionType;
    }
}