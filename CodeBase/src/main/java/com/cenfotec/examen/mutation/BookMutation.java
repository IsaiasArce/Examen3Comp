package com.cenfotec.examen.mutation;

import com.cenfotec.examen.entities.Book;
import com.cenfotec.examen.services.BookServiceImpl;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {
    @Autowired
    BookServiceImpl bookService;
    public Book createBook(String name){
        return this.bookService.createBook(name);
    }

}
