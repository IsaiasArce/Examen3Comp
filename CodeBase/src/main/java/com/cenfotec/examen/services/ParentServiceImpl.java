package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Parent;
import com.cenfotec.examen.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ParentServiceImpl implements ParentService {
    public ParentServiceImpl() {

    }

    @Autowired
    ParentRepository parentRepo;

    @Override
    public List<Parent> getAll() {
        return parentRepo.findAll();
    }

    @Override
    public Optional<Parent> findById(long id) {
        return (Optional<Parent>) parentRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public  Optional<Parent> save(Parent parent) {
        return Optional.of(parentRepo.save(parent));
    }

    @Override
    public  Optional<Parent> update(Parent parent) {
        Optional<Parent> record = parentRepo.findById(parent.getId());
        if (record.isPresent()) {
            Parent data = record.get();
            data.setName(parent.getName());
            data.setAddress(parent.getAddress());
            data.setPhone(parent.getPhone());
            return Optional.of(parentRepo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Parent> result = parentRepo.findById(id);
        if (result.isPresent()){
            parentRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
