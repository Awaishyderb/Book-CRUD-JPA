package com.example.restapp;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    //    create
    Book add(Book book){
        return  bookRepo.save(book);
    }
//    read
    List<Book> show(){
        return bookRepo.findAll();
    }
//    readSingle
    Book showSingle(long id){
        return bookRepo.findById(id).orElseThrow(()-> new EntityNotFoundException());
    }
//    delete
    void delete(long id){
         bookRepo.deleteById(id);
    }


}
