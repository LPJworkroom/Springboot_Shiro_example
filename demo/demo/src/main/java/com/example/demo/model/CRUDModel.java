package com.example.demo.model;

public class CRUDModel {
    private int id;
    private boolean isDeleted;

    public CRUDModel() {
    }

    public CRUDModel(int id, boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
