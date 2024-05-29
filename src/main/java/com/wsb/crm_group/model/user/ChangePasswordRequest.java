package com.wsb.crm_group.model.user;

import lombok.Builder;

@Builder
public record ChangePasswordRequest(String currentPassword, String newPassword, String confirmationPassword) {}
