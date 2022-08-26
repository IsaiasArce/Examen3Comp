package com.cenfotec.examen.repositories;

import com.cenfotec.examen.entities.Book;
import com.cenfotec.examen.entities.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByNameIgnoreCaseContaining(String str);
    List<Book> findAllByStatusIs(int i);
}
