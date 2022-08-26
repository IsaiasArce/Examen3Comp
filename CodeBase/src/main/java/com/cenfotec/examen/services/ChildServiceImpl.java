package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.*;
import com.cenfotec.examen.entities.Child;
import com.cenfotec.examen.repositories.BookRepository;
import com.cenfotec.examen.repositories.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            data.setPlan(child.getPlan());
            data.setAlergies(child.getAlergies());
            return Optional.of(childRepo.save(data));
        }
        return Optional.empty();
    }
    @Override
    public  Optional<Child> addBook(ChildAndBook cab) {
        Optional<Child> record = childRepo.findById(cab.getChild().getId());
        if (record.isPresent()) {
            Optional<Book> bRecord;
            Book savedBook;
            if(cab.getBook().getId()!=null){
                bRecord= bookRepo.findById(cab.getBook().getId());

            }else{
                savedBook=bookRepo.save(cab.getBook());
                bRecord= bookRepo.findById(savedBook.getId());
            }
            savedBook= bRecord.get();
            Child data = record.get();
            Set<Book> books= data.getBooks();
            books.add(savedBook);
            data.setBooks(books);

            return Optional.of(childRepo.save(data));
        }
        return Optional.empty();
    }
    @Override
    public  List<Book> getBooks(long id) {
        Optional<Child> result = childRepo.findById(id);
        if (result.isPresent()) {
            return new ArrayList<Book>(result.get().getBooks());
        }
        return null;


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
    @Override
    public List<Child> findByNameIgnoreCaseContaining(String str){
        return childRepo.findByNameIgnoreCaseContaining(str);
    }
}
