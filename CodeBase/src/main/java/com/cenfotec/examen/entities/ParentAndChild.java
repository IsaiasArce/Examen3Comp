package com.cenfotec.examen.entities;

public class ParentAndChild {
    private Child child;
    private Parent parent;

    public ParentAndChild(Child child, Parent parent) {
        this.child = child;
        this.parent = parent;
    }

    public ParentAndChild() {
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
