package controller;


import entity.Subject;
import helper.Helper;
import helper.ValidateSubject;
import repository.SubjectDAO;

import static entity.Subject.subjects;
import static entity.Subject.BASE_ID;

public class SubjectController {

    Helper helper = new Helper();
    ValidateSubject validateSubject = new ValidateSubject();
    SubjectDAO subjectDAO = new SubjectDAO();

    public void functionChoice(){
        int choice = 0;
        boolean check = true;
        while(check){
            System.out.println("[1]. Them mon hoc");
            System.out.println("[2]. In danh sach mon hoc");
            System.out.println("[3]. Quay lai");
            while(true) {
                choice = helper.getInt("Nhap lua chon chuc nang: ");
                if (choice < 1 || choice > 3) {
                    System.out.println("Cu phap khong hop le. Moi nhap lai.");
                    continue;
                }
                break;
            }
            switch (choice){
                case 1:
                    extralQuantity();
                    break;
                case 2:
                    subjectDAO.readFile();
                    break;
                case 3:
                    check = false;
                    break;
            }
        }
    }

    void extralQuantity(){
        Subject subject = new Subject();
        int value = helper.getInt("Nhap so luong mon hoc can them: ");
        for(int i=0; i<value; i++){
            subject = extralData();
            System.out.println(subject.toString());
            saveData(subject);
        }
        subjectDAO.saveDataFile();
    }

    Subject extralData(){
        String name, type;
        int totalUnit;
        Subject subject = new Subject();
        subject.setId(BASE_ID++);

        do{
            name = helper.getString("Nhap ten mon hoc: ");
            if(validateSubject.validateName(name)){
                subject.setName(name);
                break;
            }
        }while(true);

        do{
            totalUnit = helper.getInt("Nhap don vi hoc trinh: ");
            if(validateSubject.validateTotalUnit(totalUnit)){
                subject.setTotalUnit(totalUnit);
                break;
            }
        }while(true);

        subject.setType(choiceType());

        return subject;
    }

    String choiceType(){
        int choice = 0;
        String type = null;
        String DC = "Dai cuong";
        String CSN = "Co so nganh";
        String CN = "Chuyen nganh";
        System.out.println("[1]. Dai cuong");
        System.out.println("[2]. Co so nganh");
        System.out.println("[3]. Chuyen nganh");
        while(true){
            try{
                choice = helper.getInt("Nhap lua chon chuyen nganh: ");
                if(choice<1 || choice >3){
                    System.out.println("Cu phap khong hop le. Moi nhap lai");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("Cu phap khong hop le. Moi nhap lai");
            }
        }
        switch (choice){
            case 1:
                type = DC;
                break;
            case 2:
                type = CSN;
                break;
            case 3:
                type = CN;
                break;
        }
        return type;
    }

    void saveData(Subject subject){
        for(int i=0; i<subjects.length;i++){
            if(subjects[i] == null){
                subjects[i] = subject;
                return;
            }
        }
    }

    void showList(){
        for(int i=0;i<subjects.length; i++){
            if(subjects[i] == null){
                break;
            }else{
                System.out.println(subjects[i].toString());
            }
        }
    }
}
