package com.mahendravanshi.fpLibraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    private String title;

    private String author;

    @Column(unique = true)
    private String isbn;

    private String category;

    private int quantity;

    private int availableCount;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @ManyToOne
    @JoinColumn(name="borrowed_by_user_id")
    User borrowedBy;


}
