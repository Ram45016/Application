package com.artnest.springSecurity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor 
public class RegisterRequest {
    private String name;
    private String email;
    private String pwd; 
    private boolean isEnable; 

}
