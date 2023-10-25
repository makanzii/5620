package com.api.educationalsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@Getter
@Setter
public class User {
    private Long id;
    private String email;
    private String nickName;
    //@JsonIgnore
    private String password;
    private Gender gender;
    private String location;
    private Long avatar;
    private String description;
    private Role role;
    @JsonIgnore
    private LocalDateTime ctime;
    @JsonIgnore
    private LocalDateTime utime;
}
@Getter
enum Gender {
    NOT_KNOWN,
    MALE,
    FEMALE,
    NOT_APPLICABLE;
}

@Getter
@AllArgsConstructor
enum Role {
    ROLE_STUDENT,
    ROLE_EDUCATOR,
    ROLE_PARENT
}