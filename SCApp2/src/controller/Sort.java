package controller;

import entity.Student;
import entity.Transcrip;
import helper.Helper;
import repository.StudentDAO;
import repository.TranscripDAO;

import static entity.Transcrip.transcrips;

public class Sort {

    Helper helper = new Helper();
    TranscripDAO transcripDAO = new TranscripDAO();
    TranscripController transcripController = new TranscripController();

    public void functionChoice(){
        boolean check = true;
        int choice = 0;
        while(check){
            System.out.println("[1]. Sap xep theo ho ten");
            System.out.println("[2]. Sap xep theo ten mon hoc");
            System.out.println("[3]. Quay lai");
            while(true){
                choice = helper.getInt("Nhap lua chon chuc nang: ");
                if(choice<1 && choice>3){
                    System.out.println("Cu phap khong hop le. Moi nhap lai");
                    continue;
                }
                break;
            }
            switch (choice){
                case 1:
                    sortByStudentName();
                    break;
                case 2:
                    sortBySubjectName();
                    break;
                case 3:
                    check = false;
                    break;
            }
        }
    }

    void sortByStudentName(){
        for(int i=0; i<transcrips.length; i++){
            if(transcrips == null){
                break;
            }
            for(int j=i+1; j< transcrips.length; j++){
                if (transcrips[j] == null){
                    break;
                }
                if(transcrips[i].getStudent().getName().
                        compareTo(transcrips[j].getStudent().getName()) > 0){
                    Transcrip temp = transcrips[j];
                    transcrips[j] = transcrips[i];
                    transcrips[i] = temp;
                }
            }
        }
        transcripDAO.saveDataFile();
        transcripDAO.readFile();
    }

    void sortBySubjectName(){
        for(int i=0; i<transcrips.length; i++){
            if(transcrips == null){
                break;
            }
            for(int j=i+1; j< transcrips.length; j++){
                if (transcrips[j] == null){
                    break;
                }
                if(transcrips[i].getSubjectOfStudents().length
                        < transcrips[j].getSubjectOfStudents().length){
                    Transcrip temp = transcrips[j];
                    transcrips[j] = transcrips[i];
                    transcrips[i] = temp;
                }
            }
        }
        transcripDAO.saveDataFile();
        transcripDAO.readFile();
    }
}
