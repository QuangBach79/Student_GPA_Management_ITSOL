package repository;

import entity.Student;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static entity.Student.students;
import static entity.Student.studentsLimit;

public class StudentDAO {
    private final File STUDENT_DATA_FILE = new File("/Users/thieuquangbach/IdeaProjects/SCApp2/StudentDAO.txt");

    public static String toString(Object[] a) {
        if (a == null)
            return "null";

        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append("");
        for (int i = 0; ; i++) {
            b.append(String.valueOf(a[i]));
            if (i == iMax)
                return b.append("").toString();
            b.append("\n ");
        }
    }

    Student[] limitArrayData(){
        int count=0;
        for(int i=0; i<students.length; i++){
            if(students[i] != null){
                count++;
            }else{
                break;
            }
        }
//        return count;
        studentsLimit = new Student[count];
        for(int i=0; i<count; i++){
            studentsLimit[i] = students[i];
        }
        return studentsLimit;
    }
    public void saveDataFile(){
        Student[] studentsLimit = limitArrayData();
        try{
            PrintWriter pw = new PrintWriter(STUDENT_DATA_FILE,"UTF-8");;
            pw.println(toString(studentsLimit));
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFile(){
//        File f = new File(String.valueOf(STUDENT_DATA_FILE));
        try{
            BufferedReader br = Files.newBufferedReader(STUDENT_DATA_FILE.toPath(), StandardCharsets.UTF_8);
            String line = null;
            while(true){
                line = br.readLine();
                if(line == null){
                    break;
                }else{
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
