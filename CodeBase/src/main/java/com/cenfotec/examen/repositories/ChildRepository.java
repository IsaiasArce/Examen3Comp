package com.cenfotec.examen.repositories;

import com.cenfotec.examen.entities.Child;
import com.cenfotec.examen.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child,Long> {
}
