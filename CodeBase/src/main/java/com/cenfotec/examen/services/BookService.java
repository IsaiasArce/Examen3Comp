package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Book;
import com.cenfotec.examen.entities.Parent;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getAll();
    public List<Book> getActive();
    public List<Book> findByName(String str);
    public Optional<Book> findById(long id);
    public Optional<Book> save(Book book);
    public Optional<Book> update(Book book);
    public boolean delete(Long id);
    public int deleteLogic(long id);
}
