package controller;

import entity.Student;
import entity.Subject;
import entity.SubjectOfStudent;
import entity.Transcrip;
import helper.Helper;
import repository.TranscripDAO;

import java.util.Arrays;

import static entity.Student.students;
import static entity.Subject.subjects;
import static  entity.SubjectOfStudent.subjectOfStudents;
import static entity.Transcrip.transcrips;

public class TranscripController {
    Helper hepler = new Helper();
    TranscripDAO transcripDAO = new TranscripDAO();

    public void functionChoice(){
        int choice = 0;
        boolean check = true;
        while(check){
            System.out.println("[1]. Chinh sua bang diem");
            System.out.println("[2]. In bang diem");
            System.out.println("[3]. Quay lai");
            do {
                choice = hepler.getInt("Nhap lua chon chuc nang: ");
                if(choice<1 || choice>3){
                    continue;
                }else{
                    break;
                }
            }while(true);
            switch(choice){
                case 1:
                    TranscripManagement();
                    break;
                case 2:
                    transcripDAO.readFile();
                    break;
                case 3:
                    check = false;
                    break;

            }
        }
    }

    public void TranscripManagement(){
        int numberOfSubject, point;
        Subject subject = new Subject();
        Student student = new Student();
        Transcrip transcrip = new Transcrip(student, subjectOfStudents);
        SubjectOfStudent subjectOfStudent = new SubjectOfStudent();

        student = choiceStudent();

        numberOfSubject = extralSubjectNumber();

        subjectOfStudents = new SubjectOfStudent[numberOfSubject];
        for(int i=0; i<numberOfSubject; i++){
            subject = choiceSubject();
            point = extraPointSubject();
            subjectOfStudent = new SubjectOfStudent(subject,point);
            saveData1(subjectOfStudent);
        }
        transcrip = new Transcrip(student,subjectOfStudents);
        saveData2(transcrip);
        transcripDAO.saveDataFile();
    }
    Student choiceStudent(){
        Student student = new Student();
        int choice = 0;
        do {
            choice = hepler.getInt("Nhap Id sinh vien: ");
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null && students[i].getId() == choice) {
                    student = students[i];
                    break;
                }
            }
            if(student != null){
                System.out.println(student.toString());
                break;
            }
            System.out.println("Id sinh vien khong ton tai");
        }while(true);
        return student;
    }

    int extralSubjectNumber(){
        int numberOfSubject = 0;
        numberOfSubject = hepler.getInt("Nhap so mon hoc cua sinh vien: ");
        return numberOfSubject;
    }

    Subject choiceSubject(){
        int choice = 0;
        Subject subject = new Subject();
        do{
            choice = hepler.getInt("Nhap id mon hoc: ");
            for(int i=0; i<subjects.length; i++){
                if(subjects[i].getId() == choice){
                    subject = subjects[i];
                    break;
                }
            }
            if(subject != null){
                System.out.println(subject.toString());
                break;
            }
            System.out.println("Mon hoc khong ton tai");
        }while(true);
        return subject;
    }

    int extraPointSubject(){
        int point = 0;
        point = hepler.getInt("Nhap diem mon hoc: ");
        return point;
    }

    public void saveData1(SubjectOfStudent subjectOfStudent){
        for(int i=0; i< subjectOfStudents.length; i++){
            if(subjectOfStudents[i] == null){
                subjectOfStudents[i] = subjectOfStudent;
                System.out.println(subjectOfStudent.toString());
                return;
            }
        }
    }

    public void saveData2(Transcrip transcrip){
        for(int i=0; i<transcrips.length; i++){
            if(transcrips[i] == null){
                transcrips[i] = transcrip;
                return;
            }
        }
    }
}
