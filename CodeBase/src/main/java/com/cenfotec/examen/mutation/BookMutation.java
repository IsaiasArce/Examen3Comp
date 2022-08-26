package com.cenfotec.examen.mutation;

import com.cenfotec.examen.entities.Book;
import com.cenfotec.examen.services.BookServiceImpl;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookMutation implements GraphQLMutationResolver {
    @Autowired
    BookServiceImpl bookService;
    public Book createBook(String name){
        return this.bookService.createBook(name);
    }
    public Book updateBook(Integer id, String name, Integer status){
        Optional<Book> book = bookService.findById(id);
        if(book.isPresent()){
            Book bookToUpdate= new Book();
            bookToUpdate.setStatus(status);
            bookToUpdate.setName(name);

            bookService.updateBook(bookToUpdate);
            return  bookToUpdate;
        }
        else {
            return  null;
        }
    }
    public Optional<Book> getBook(int id){
        return this.bookService.findById(id);
    }
    public List<Book>  getBooks(int count){return  this.bookService.getActive().stream().limit(count).collect(Collectors.toList());}
    public int deleteLogic(int id){
        Optional<Book> book = bookService.findById(id);
        if(book.isPresent()){
            Book bookToUpdate= new Book();
            bookToUpdate.setId(book.get().getId());
            bookToUpdate.setName(book.get().getName());
            bookToUpdate.setStatus(2);

            bookService.updateBook(bookToUpdate);
            return  0;
        }
        else {
            return 1 ;
        }

    }
}
