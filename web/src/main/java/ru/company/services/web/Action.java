package ru.company.services.web;

public enum Action {

    ADD("Save"),
    EDIT("Update"),
    DELETE("Delete");

    private String name;

    Action(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
