package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Child;
import com.cenfotec.examen.entities.Parent;
import com.cenfotec.examen.entities.ParentAndChild;
import com.cenfotec.examen.repositories.ChildRepository;
import com.cenfotec.examen.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ParentServiceImpl implements ParentService {
    public ParentServiceImpl() {

    }

    @Autowired
    ParentRepository parentRepo;
    @Autowired
    ChildRepository childRepo;

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
            data.setChildren(parent.getChildren());
            return Optional.of(parentRepo.save(data));
        }
        return Optional.empty();
    }
    @Override
    public  Optional<Parent> addChild(ParentAndChild pac) {
        Optional<Parent> record = parentRepo.findById(pac.getParent().getId());
        if (record.isPresent()) {
            Optional<Child> cRecord;
            Child savedChild;
            if(pac.getChild().getId()!=null){
                 cRecord= childRepo.findById(pac.getChild().getId());

            }else{
                savedChild=childRepo.save(pac.getChild());
                cRecord= childRepo.findById(savedChild.getId());
            }
            savedChild= cRecord.get();
            Parent data = record.get();
            Set<Child> children= data.getChildren();
            children.add(savedChild);
            data.setChildren(children);

            return Optional.of(parentRepo.save(data));
        }
        return Optional.empty();
    }
    @Override
    public  List<Child> getChildren(long id) {
        Optional<Parent> result = parentRepo.findById(id);
        if (result.isPresent()) {
            return new ArrayList<Child>(result.get().getChildren());
        }
        return null;


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
