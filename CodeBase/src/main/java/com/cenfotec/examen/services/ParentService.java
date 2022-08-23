package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Parent;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    public List<Parent> getAll();
    public Optional<Parent> findById(long id);
    public Optional<Parent> save(Parent parent);
    public Optional<Parent> update(Parent parent);
    public boolean delete(Long id);
}
