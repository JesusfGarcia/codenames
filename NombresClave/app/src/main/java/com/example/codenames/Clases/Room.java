package com.example.codenames.Clases;

public class Room {
    private String name;
    private String freespaces;
    private String created_at;
    private Boolean state;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public void setFreespaces(String freespaces) {
        this.freespaces = freespaces;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}


