package entity;

import java.util.Arrays;

public class Transcrip {
    public static Transcrip[] transcrips = new Transcrip[100];
    public static Transcrip[] transcripslimit;
    private Student student;
    private SubjectOfStudent[] subjectOfStudents;

    public Transcrip(){}

    public Transcrip(Student student, SubjectOfStudent[] subjectOfStudents) {
        this.student = student;
        this.subjectOfStudents = subjectOfStudents;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SubjectOfStudent[] getSubjectOfStudents() {
        return subjectOfStudents;
    }

    public void setSubjectOfStudents(SubjectOfStudent[] subjectOfStudents) {
        this.subjectOfStudents = subjectOfStudents;
    }

    String toString2(Object[] a) {
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
            b.append("\n                      ");
        }
    }

    @Override
    public String toString() {
        return "Transcrip:\n" +
                "\tstudent=" + student + "\n" +
                "\tsubjectOfStudents=" + toString2(subjectOfStudents)
                ;
    }
}
