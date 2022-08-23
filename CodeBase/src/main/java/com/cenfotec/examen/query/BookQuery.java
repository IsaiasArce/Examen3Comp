package com.cenfotec.examen.query;

import com.cenfotec.examen.entities.Book;
import com.cenfotec.examen.services.BookService;
import com.cenfotec.examen.services.BookServiceImpl;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class BookQuery implements GraphQLQueryResolver {
    @Autowired
    private BookServiceImpl bookService;
    public List<Book> getBooks(int count) {
        return this.bookService.getAllBooks(count);
    }
    public Optional<Book> getBook(int id) {
        return this.bookService.findById(id);
    }
    public void updateBook(Book book) {
        bookService.updateBook(book);
    }
    
}
