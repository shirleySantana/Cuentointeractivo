package com.example.profesoresi.cuentointeractivo;

/**
 * Created by profesoresi on 27/11/2015.
 */
public class Choice {
    private String text;
    private int nextId;

    public Choice(String text, int nextId) {
        this.text = text;
        this.nextId = nextId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }
}
