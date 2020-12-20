package com.example.demo.model;

public class Bed extends CRUDModel{
    private int id;
    private String roomNumber;
    private int bedStatus=0;
    private int isDeleted=0;

    public Bed() {
    }

    public Bed(String roomNumber, int id, int bedStatus, int isDeleted) {
        this.roomNumber = roomNumber;
        this.id = id;
        this.bedStatus = bedStatus;
        this.isDeleted = isDeleted;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBedStatus() {
        return bedStatus;
    }

    public void setBedStatus(int bedStatus) {
        this.bedStatus = bedStatus;
    }
}
