package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getAll();
    public Optional<Book> findById(long id);
    public Optional<Book> save(Book book);
    public Optional<Book> update(Book book);
    public boolean delete(Long id);
}
