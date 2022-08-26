package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Book;
import com.cenfotec.examen.entities.Child;
import com.cenfotec.examen.entities.ChildAndBook;

import java.util.List;
import java.util.Optional;

public interface ChildService {
    public List<Child> getAll();
    public Optional<Child> findById(long id);
    public List <Child> findByNameIgnoreCaseContaining(String str);
    public Optional<Child> save(Child child);
    public Optional<Child> update(Child child);
    public Optional<Child> addBook(ChildAndBook cab);
    public  List<Book> getBooks(long id);
    public boolean delete(Long id);
}
