package controller;

import entity.Student;
import helper.Helper;
import helper.ValidateStudent;
import repository.StudentDAO;

import static entity.Student.students;

import static entity.Student.BASE_ID;

public class StudentControlelr {
    // nhap so luong them, nhap thong tin tung nguoi, save, in

    Helper helper = new Helper();
    ValidateStudent validateStudent = new ValidateStudent();
    StudentDAO studentDAO = new StudentDAO();

    public void functionChoice(){
        int choice = 0;
        boolean check = true;
        while(check){
            System.out.println("[1]. Them sinh vien");
            System.out.println("[2]. In danh sach sinh vien");
            System.out.println("[3]. Quay lai");
            while(true){
                choice = helper.getInt("Nhap lua chon chuc nang: ");
                if(choice<1 || choice >3){
                    System.out.println("Lua chon khong hop le. Moi nhap lai.");
                    continue;
                }
                break;
            }
            switch (choice){
                case 1:
                    extraQuantity();
                    break;
                case 2:
//                    showList();
                    studentDAO.readFile();
                    break;
                case 3:
                    check = false;
                    break;
            }
        }
    }

    void extraQuantity(){
        int value = 0;
        Student student = new Student();
        value = helper.getInt("Nhap so luong sinh vien can them: ");
        for(int i=0; i<value; i++){
            student = extraData();
            System.out.println(student.toString());
            saveData(student);
        }
        studentDAO.saveDataFile();
    }
    Student extraData(){
        String name, address, numberPhone, roomClass;
        Student student = new Student();
        student.setId(BASE_ID++);

        do{
            name = helper.getString("Nhap ten sinh vien: ");
            if(validateStudent.validateName(name)){
                student.setName(name);
                break;
            }
            System.out.println("Nhap ten sinh vien co loi");
        }while(true);

        do{
            address = helper.getString("Nhap dia chi sinh vien: ");
            if(validateStudent.validateAddress(address)){
                student.setAddress(address);
                break;
            }
            System.out.println("Nhap dia chi sinh vien co loi");
        }while(true);

        do{
            numberPhone = helper.getString("Nhap so lien lac sinh vien: ");
            if(validateStudent.validateNumberPhone(numberPhone)){
                student.setNumberPhone(numberPhone);
                break;
            }
            System.out.println("Nhap so lien lac sinh vien co loi");
        }while (true);

        do{
            roomClass = helper.getString("Nhap lop sinh vien: ");
            if(validateStudent.validateRoomClass(roomClass)){
                student.setRoomClass(roomClass);
                break;
            }
            System.out.println("Nhap lop sinh vien co loi");
        }while (true);

        return student;
    }

    void saveData(Student student){
        for(int i=0; i<students.length; i++){
            if(students[i] == null){
                students[i] = student;
                return;
            }
        }
    }

    void showList(){
        for(int i=0; i<students.length; i++){
            if(students[i] != null){
                System.out.println(students[i].toString());
                continue;
            }
            if(students[i] == null){
                break;
            }
        }
    }
}
