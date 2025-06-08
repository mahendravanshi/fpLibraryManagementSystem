package com.mahendravanshi.fpLibraryManagementSystem.controller;

import com.mahendravanshi.fpLibraryManagementSystem.entity.Library;
import com.mahendravanshi.fpLibraryManagementSystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController {


    @Autowired
    private LibraryService libraryService;


    @PostMapping
    public ResponseEntity<Library> addLibrary(@RequestBody Library library) {
        return new ResponseEntity<>(libraryService.addLibrary(library), HttpStatus.OK);
    }

    @GetMapping("/{library_id")
    public ResponseEntity<Library> getLibraryById(@PathVariable Integer library_id){
        return new ResponseEntity<>(libraryService.getLibraryById(library_id),HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Library> updateLibrary(@RequestBody Library library){
        return new ResponseEntity<>(libraryService.updateLibrary(library),HttpStatus.OK);
    }


    @DeleteMapping("/{library_id")
    public ResponseEntity<Library> deleteLibrary(@PathVariable Integer library_id){
         return new ResponseEntity<>(libraryService.deleteLibrary(library_id),HttpStatus.OK);
    }





}
