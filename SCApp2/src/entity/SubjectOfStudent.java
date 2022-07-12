package entity;

import java.util.Arrays;

public class SubjectOfStudent {
    public static SubjectOfStudent[] subjectOfStudents;
    private Subject subject;
    private int ponint;

    public SubjectOfStudent(){}

    public SubjectOfStudent(Subject subject, int ponint) {
        this.subject = subject;
        this.ponint = ponint;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getPonint() {
        return ponint;
    }

    public void setPonint(int ponint) {
        this.ponint = ponint;
    }

    @Override
    public String toString() {
        return "{" +
                "subject=" + subject +
                ", ponint=" + ponint +
                '}';
    }
}
