package com.common.security;

import lombok.Data;

import java.util.UUID;

@Data
public class UserContext {
    private UUID userId;
    private String username;
    private String userType;
    private String userCategory;
    private boolean active;
}
