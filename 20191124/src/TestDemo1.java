import java.util.Arrays;

class Student implements Comparable<Student>{
    public String name;
    public int age;
    public double score;
    public Student(String name,int age,double score){
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{"+"name="+name +",age ="+age+",score ="+score+'}';
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
        //return this.name-o.name;//从小到大
        //return (int)(this.score-o.score);
    }
}




public class TestDemo1 {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("zhangsan",30,69.5);
        students[1] = new Student("lisi", 45, 75.5);
        students[2] = new Student("caocao", 35, 57.5);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
