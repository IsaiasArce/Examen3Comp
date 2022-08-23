package com.cenfotec.examen.controllers;

import com.cenfotec.examen.entities.Parent;
import com.cenfotec.examen.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/parents"})
public class ParentsController {

    @Autowired
    private ParentService parentService;

    @GetMapping
    public List getAll(){
        return parentService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Parent> findById(@PathVariable long id){
        Optional<Parent> result = parentService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Parent create(@RequestBody Parent parent){
        return parentService.save(parent).get();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Parent> update(@PathVariable("id") long id,
                                          @RequestBody Parent parent){
        parent.setId(id);
        Optional<Parent> result = parentService.update(parent);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (parentService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}