package com.company.kiosk.domain;

public class Menu {
    private String name;
    private String comment;

    public String getComment() {
        return comment;
    }

    public String getName() {
        return name;
    }

    public Menu(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return name + "\t\t\t| "+
                comment;
    }
}
