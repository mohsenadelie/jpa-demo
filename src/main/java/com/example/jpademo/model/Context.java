package com.example.jpademo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Context {
    @ElementCollection
    private Map<String, Integer> contextMap;

    @Basic(optional = true, fetch = FetchType.LAZY)
    private Integer pageNumber;
}
