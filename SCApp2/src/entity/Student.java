package entity;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    public static int BASE_ID = 10000;
    public static Student[] students = new Student[100];
    public static Student[] studentsLimit;
    private int id;
    private String roomClass;

    public Student(){}

    public Student(int BASE_ID, int id, String roomClass) {
        this.BASE_ID = BASE_ID;
        this.id = id;
        this.roomClass = roomClass;
    }

    public Student(String name, String address, String numberPhone, int BASE_ID, int id, String roomClass) {
        super(name, address, numberPhone);
        this.BASE_ID = BASE_ID;
        this.id = id;
        this.roomClass = roomClass;
    }

    public int getBASE_ID() {
        return BASE_ID;
    }

    public void setBASE_ID(int BASE_ID) {
        Student.BASE_ID = BASE_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    @Override
    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                "| name= " + getName() +
//                "| address= " + getAddress() +
//                "| phoneNumber= " + getNumberPhone() +
//                "| roomClass=" + roomClass +
//                '}';

        return String.format(
//                "+----------------------------------------------------------------------+\n" +
                "|%7d|%20s|%15s|%12s|%12s|", id, getName(), getAddress(), getNumberPhone(), getRoomClass()
        );
    }

}
