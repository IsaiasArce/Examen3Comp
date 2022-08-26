package com.cenfotec.examen.controllers;

import com.cenfotec.examen.entities.Child;
import com.cenfotec.examen.entities.ChildAndBook;
import com.cenfotec.examen.entities.Parent;
import com.cenfotec.examen.entities.ParentAndChild;
import com.cenfotec.examen.services.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/children"})
public class ChildrenController {
    @Autowired
    private ChildService childService;

    @GetMapping
    public List getAll(){
        return childService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Child> findById(@PathVariable long id){
        Optional<Child> result = childService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Child create(@RequestBody Child child){
        return childService.save(child).get();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Child> update(@PathVariable("id") long id,
                                         @RequestBody Child child){
        child.setId(id);
        Optional<Child> result = childService.update(child);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping(value="/{id}/books/add")
    public ResponseEntity<Child> addChild(@PathVariable("id") long id,
                                           @RequestBody ChildAndBook cab){

        cab.getChild().setId(id);
        Optional<Child> result = childService.addBook(cab);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (childService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
