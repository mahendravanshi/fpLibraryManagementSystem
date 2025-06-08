package com.mahendravanshi.fpLibraryManagementSystem.service;


import com.mahendravanshi.fpLibraryManagementSystem.NotFoundException;
import com.mahendravanshi.fpLibraryManagementSystem.entity.Library;
import com.mahendravanshi.fpLibraryManagementSystem.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

       public Library addLibrary(Library library){
           return libraryRepository.save(library);
       }

      public Library getLibraryById(Integer libraryId){

             Optional<Library> library = libraryRepository.findById(libraryId);
             if(library.isPresent()){
                 return library.get();
             }

             throw new NotFoundException("No library found with library id "+ libraryId );
      }

      public Library updateLibrary(Library library){

          Optional<Library> library1 =  libraryRepository.findById(library.getLibrary_id());

          if(library1.isPresent()){
              return libraryRepository.save(library);
          }
          throw new NotFoundException("No library found with library id to update "+ library.getLibrary_id());

      }

      public Library deleteLibrary(Integer libraryId) {

          Optional<Library> library = libraryRepository.findById(libraryId);

          if(library.isPresent()){
                libraryRepository.deleteById(libraryId);
                return library.get();
          }
            throw new NotFoundException("No library found with library id to delete "+ libraryId);

      }

}
