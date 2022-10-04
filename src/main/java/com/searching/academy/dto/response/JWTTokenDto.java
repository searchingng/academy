package com.searching.academy.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.searching.academy.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JWTTokenDto {
    private String token;
    private boolean success;
    private String name;
    private Role role;

    public JWTTokenDto(String token) {
        this.token = token;
    }

    @JsonProperty("id_token")
    public String getToken() {
        return token;
    }

    public void setIdToken(String token) {
        this.token = token;
    }

}
