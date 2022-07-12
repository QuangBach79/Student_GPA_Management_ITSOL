package repository;

import entity.Subject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static entity.Subject.subjects;
import static entity.Subject.subjectslimit;

public class SubjectDAO {
    private final File SUBJECT_DATA_FILE = new File("/Users/thieuquangbach/IdeaProjects/SCApp2/SubjectDAO.txt");

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

    Subject[] limitArraysData(){
        int count = 0;
        for(int i=0; i<subjects.length; i++){
            if(subjects[i] != null){
                count++;
            }else{
                break;
            }
        }
        subjectslimit = new Subject[count];
        for(int i=0; i<count; i++){
            subjectslimit[i] = subjects[i];
        }
        return subjectslimit;
    }

    public void saveDataFile(){
        Subject[] subjectsLimit = limitArraysData();
        try {
            PrintWriter pw = new PrintWriter(SUBJECT_DATA_FILE,"UTF-8");
            pw.println(toString(subjectsLimit));
            pw.flush();
            pw.close();
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFile(){
//        File f = new File(String.valueOf(SUBJECT_DATA_FILE));
        try{
            BufferedReader br = Files.newBufferedReader(SUBJECT_DATA_FILE.toPath(), StandardCharsets.UTF_8);
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
