package com.example.jpademo.mappers;

import com.example.jpademo.dtos.AuthorDto;
import com.example.jpademo.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorMapperTest {
    @Autowired
    protected AuthorMapper authorMapper;

    @Test
    void convertDtoToEntity() {
        AuthorDto authorDto = new AuthorDto().setName("a").setPseudonym("b").setMyId(2L);
        Author author = authorMapper.convertDtoToEntity(authorDto);
        System.out.println(author);
    }

    @Test
    void convertEntityToDto() {
        Author author = (Author) new Author().setPseudonym("b").setName("a").setId(2L);
        AuthorDto authorDto = authorMapper.convertEntityToDto(author);
        System.out.println(authorDto);
    }
}