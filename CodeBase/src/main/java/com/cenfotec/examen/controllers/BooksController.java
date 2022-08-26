package com.cenfotec.examen.controllers;

import com.cenfotec.examen.entities.Book;
import com.cenfotec.examen.entities.Parent;
import com.cenfotec.examen.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/books"})
public class BooksController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List getAll(){
        return bookService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Book> findById(@PathVariable long id){
        Optional<Book> result = bookService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Book create(@RequestBody Book book){
        return bookService.save(book).get();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Book> update(@PathVariable("id") long id,
                                         @RequestBody Book book){
        book.setId(id);
        Optional<Book> result = bookService.update(book);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping(path = {"/find/{name}"})
    public ResponseEntity <List<Book>> findById(@PathVariable String name){
        List<Book> result = bookService.findByName(name);
        if (result!=null){
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (bookService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
