package com.learn.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.learn.security.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
	
  @JsonProperty("access_token")
  private String accessToken;
  
  @JsonProperty("refresh_token")
  private String refreshToken;
  
  @JsonProperty("usersData")
  private UsersData usersData;
  
//  private UserData user;
  
}
