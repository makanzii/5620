package com.api.educationalsystem.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class LoginVO {
    private Long id;
    private String email;
    private String nickName;
    private String token;
}
