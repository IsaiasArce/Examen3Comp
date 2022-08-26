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

    @Override
    public List<Book> getActive() {
        return
                this.bookRepo.findAllByStatusIs(1);
    }
    public List<Book> getBooks(int count) {
        return   this.bookRepo.findAllByStatusIs(1).stream().limit(count).collect(Collectors.toList());
    }
    public Book createBook(String name) {

        Book book = new Book();
        book.setName(name);
        book.setStatus(1);
        return this.bookRepo.save(book);
    }
    @Override
    public List<Book> findByName(String str){
        return  bookRepo.findByNameIgnoreCaseContaining(str);
    }
    @Override
    public int deleteLogic(long id){
        Optional<Book> record = bookRepo.findById(id);
        if (record.isPresent()) {
            Book data = record.get();
            data.setStatus(2);
            bookRepo.save(data);
            return 0;
        }
        return 1;

    }
    public void updateBook(Book bookToUpdate) {
        this.bookRepo.save(bookToUpdate);
    }
    
}
