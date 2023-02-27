package session09;

import javax.swing.plaf.PanelUI;

public class Student {
    private Course course;
    public Student(){
        this.course = new Course();
        course.setScore(1000);
    }
    public long getScore(){
        return course.getScore();
    }

    public static void main(String[] args) {
        Student p = new Student();
        System.out.println(p.getScore());
    }
}
