package com.example.jpademo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class AuthorDto {
    private Long myId;
    private String name;
    private String pseudonym;
}
