package com.example.jpademo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Author extends Person {

    private String pseudonym;

    @ManyToMany(mappedBy = "authorList",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Book> bookList;
}
