package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Book;
import com.cenfotec.examen.entities.Child;
import com.cenfotec.examen.entities.ChildAndBook;
import com.cenfotec.examen.repositories.BookRepository;
import com.cenfotec.examen.repositories.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ChildServiceImpl implements  ChildService {
    @Autowired
    ChildRepository childRepo;
    @Autowired
    BookRepository bookRepo;

    @Override
    public List<Child> getAll() {
        return childRepo.findAll();
    }

    @Override
    public Optional<Child> findById(long id) {
        return (Optional<Child>) childRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public  Optional<Child> save(Child child) {
        return Optional.of(childRepo.save(child));
    }

    @Override
    public  Optional<Child> update(Child child) {
        Optional<Child> record = childRepo.findById(child.getId());
        if (record.isPresent()) {
            Child data = record.get();
            data.setName(child.getName());
            return Optional.of(childRepo.save(data));
        }
        return Optional.empty();
    }
    @Override
    public  Optional<Child> addBook(ChildAndBook cab) {
        Optional<Child> record = childRepo.findById(cab.getChild().getId());

        if (record.isPresent()) {

            Optional<Book> bookRecord = bookRepo.findById(cab.getBook().getId());
            Book savedBook;
            if (!bookRecord.isPresent()){
                savedBook= bookRepo.save(cab.getBook());
            }else{
                savedBook= bookRepo.getById(cab.getBook().getId());
            }

            Child data = record.get();
            Set<Book> books= data.getBooks();
            books.add(savedBook);
            data.setBooks(books);
            return Optional.of(childRepo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Child> result = childRepo.findById(id);
        if (result.isPresent()){
            childRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
