package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Child;
import com.cenfotec.examen.entities.Parent;
import com.cenfotec.examen.entities.ParentAndChild;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    public List<Parent> getAll();
    public List<Child> getChildren(long id);
    public Optional<Parent> findById(long id);
    public Optional<Parent> save(Parent parent);
    public Optional<Parent> update(Parent parent);
    public Optional<Parent> addChild(ParentAndChild pac);
    public boolean delete(Long id);
}
