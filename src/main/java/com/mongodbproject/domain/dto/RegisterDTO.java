package com.mongodbproject.domain.dto;

import com.mongodbproject.domain.enums.UserRoles;

public record RegisterDTO(String login, String password, UserRoles role) {

}
