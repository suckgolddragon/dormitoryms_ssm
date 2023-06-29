package com.southwind.mapper;

import com.southwind.entity.SystemAdmin;

public interface SystemAdminMapper {
    public SystemAdmin findByUsername(String username);
}
