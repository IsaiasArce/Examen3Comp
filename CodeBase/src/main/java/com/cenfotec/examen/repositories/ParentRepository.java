package com.cenfotec.examen.repositories;

import com.cenfotec.examen.entities.Child;
import com.cenfotec.examen.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent,Long> {
    List<Parent> findByNameIgnoreCaseContaining(String str);

}
