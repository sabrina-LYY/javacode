import java.util.Arrays;


//如果要排序自己定义的类型，需要手动进行实现Comparable接口 T表示泛型
class Student implements Comparable <Student>{
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override//Alt+enter键
    public int compareTo(Student o) {
        //return this.age - o.age;//从小到大排序
        //return (int)(this.score-o.score);
        return this.name.compareTo(o.name);//字符串比较用compareTo
        //return 0;
    }
}


public class TestDemo5 {
    public static void main(String[] args) {
        Student[] students= new Student[3];
        students[0] = new Student("zhangfei",20,56.3);
        students[1] = new Student("caocao",35,89.2);
        students[2] = new Student("liubei",25,75.3);
        Arrays.sort(students);//排序
        System.out.println(Arrays.toString(students));

    }
}
