package com.fruit.Htp.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@FieldDefaults (level = AccessLevel.PRIVATE)
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @ManyToOne
    User user;
    String image;
    String description;
    boolean vegetarian ;
    LocalDateTime createAt;
    @ElementCollection
    List<Long> likes = new ArrayList<>();


}
