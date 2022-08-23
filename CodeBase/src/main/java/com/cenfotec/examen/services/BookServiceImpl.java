package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Book;
import com.cenfotec.examen.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements   BookService{
    public BookServiceImpl() {

    }
    @Autowired
    BookRepository bookRepo;

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> findById(long id) {
        return (Optional<Book>) bookRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public  Optional<Book> save(Book book) {
        return Optional.of(bookRepo.save(book));
    }

    @Override
    public  Optional<Book> update(Book book) {
        Optional<Book> record = bookRepo.findById(book.getId());
        if (record.isPresent()) {
            Book data = record.get();
            data.setName(book.getName());
            return Optional.of(bookRepo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Book> result = bookRepo.findById(id);
        if (result.isPresent()){
            bookRepo.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Book> getAllBooks(int count) {
        return
                this.bookRepo.findAll().stream().limit(count).collect(Collectors.toList());
    }
    public Book createBook(String name) {

        Book book = new Book();
        book.setName(name);
        book.setStatus(1);
        return this.bookRepo.save(book);
    }
    public void updateBook(Book bookToUpdate) {
        this.bookRepo.save(bookToUpdate);
    }
    
}
