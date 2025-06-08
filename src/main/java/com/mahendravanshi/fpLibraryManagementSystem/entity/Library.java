package com.mahendravanshi.fpLibraryManagementSystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`library`")
public class Library {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     private int library_id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "library",cascade=CascadeType.ALL)
    private List<Book> books;
}
