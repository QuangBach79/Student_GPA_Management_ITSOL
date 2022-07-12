package repository;

import entity.Student;
import entity.Transcrip;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static entity.Transcrip.transcrips;
import static entity.Transcrip.transcripslimit;

public class TranscripDAO {
    private final File TRANSCRIP_DATA_FILE = new File("/Users/thieuquangbach/IdeaProjects/SCApp2/TranscripDAO.txt");


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
            b.append("\n");
        }
    }

    Transcrip[] limitArrayData(){
        int count=0;
        for(int i=0; i<transcrips.length; i++){
            if(transcrips[i] != null){
                count++;
            }else{
                break;
            }
        }
//        return count;
        transcripslimit = new Transcrip[count];
        for(int i=0; i<count; i++){
            transcripslimit[i] = transcrips[i];
        }
        return transcripslimit;
    }
    public void saveDataFile(){
        Transcrip[] transcripslimit = limitArrayData();
        try{
            PrintWriter pw = new PrintWriter(TRANSCRIP_DATA_FILE,"UTF-8");
            pw.println(toString(transcripslimit));
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
            BufferedReader br = Files.newBufferedReader(TRANSCRIP_DATA_FILE.toPath(), StandardCharsets.UTF_8);
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
