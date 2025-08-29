package com.example.AiRepoScrening.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthReponseDto {

        private Long userId;

        private String token;
        private UserRole role;


}
