package com.cenfotec.examen.repositories;

import com.cenfotec.examen.entities.Book;
import com.cenfotec.examen.entities.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
