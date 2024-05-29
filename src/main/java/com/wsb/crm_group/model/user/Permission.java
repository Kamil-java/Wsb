package com.wsb.crm_group.model.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    MANAGE_READ("management:read"),
    MANAGE_UPDATE("management:update"),
    MANAGE_CREATE("management:create"),
    MANAGE_DELETE("management:delete")

    ;

    @Getter
    private final String permission;
}
