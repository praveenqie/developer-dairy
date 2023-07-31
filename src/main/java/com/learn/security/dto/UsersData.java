package com.learn.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersData {

	  private Integer id;
	  private String firstname;
	  private String lastname;
	  private String email;
	  
	
	  
	  

}
