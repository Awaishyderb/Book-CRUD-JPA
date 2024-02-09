package com.example.restapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    //    create
    @PostMapping("/add")
   @ResponseBody Book add(@RequestParam String title,@RequestParam String author,@RequestParam long pages){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPages(pages);
        return service.add(book);
    }
//    show
    @GetMapping("/show")
   @ResponseBody List<Book> show(){
        return service.show();
    }
//    ShowSingle
    @PostMapping("/id")
   @ResponseBody Book showSingle(@RequestParam long id){
        return service.showSingle(id);
    }

//    delete
    @DeleteMapping("/delete")
    String delete(@PathVariable @RequestParam long id){
        service.delete(id);
        return "deleted!";
    }
}

