import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class TestDemo {
    public class Substr {
        public boolean[] chkSubStr(String[] p, int n, String s) {
            boolean[] bol = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (s.contains(p[i])) {
                    bol[i] = true;
                } else {
                    bol[i] = false;
                }
            }
            return bol;
        }
    }


    static class Student implements Comparable<Student> {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return o.score - this.score;
        }
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Student student = new Student(in.next(), in.nextInt());
            students.add(student);
        }
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student.name + " " + student.score);
        }

    }


}
