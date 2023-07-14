package com.project.todo.dto;

import com.project.todo.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequest {

    private String username;

    private String email;

    private Role role;

    private String password;
}
