package com.example.jpademo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@SecondaryTable(name = "cover_book",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "book_id"))
public class Book extends BaseEntity {
    private String title;

    @OneToOne
    @JoinColumn(name = "summary_id")
    private Summary summary;

    @Embedded
    private Context context;

    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "reference", joinColumns = @JoinColumn(name = "book_id"))
    private List<String> references;

    @Column(table = "cover_book")
    private String cover;

    @Column(table = "cover_book")
    private Integer price;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "book_author_list",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Author> authorList;

    @Enumerated(EnumType.STRING)
    private Genre genre;
}
