package com.example.jpademo.mappers;

import com.example.jpademo.dtos.AuthorDto;
import com.example.jpademo.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mappings({@Mapping(source = "authorDto.myId", target = "id"),
            @Mapping(source = "authorDto.name", target = "name")})
    Author convertDtoToEntity(AuthorDto authorDto);

    @Mapping(source = "author.id", target = "myId")
    AuthorDto convertEntityToDto(Author author);
}
