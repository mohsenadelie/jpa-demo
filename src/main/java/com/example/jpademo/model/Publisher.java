package com.example.jpademo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Publisher extends Person {

    private String address;

    @OneToMany(mappedBy = "publisher",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Book> bookList;


}
