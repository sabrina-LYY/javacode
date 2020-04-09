import java.util.*;

//按成绩顺序将学生排序
class Student{
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
public class Main{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();//第一行输入人数
            int select = in.nextInt();//第二行表示选择升序还是降序，0表示按降序排列，1表示升序
            List<Student> list = new ArrayList<>();
            for(int i=0;i<num;i++){
                list.add(new Student(in.next(),in.nextInt()));//下面几行输入姓名+成绩
            }
            if(select==0){
                Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.score-o1.score;
                    }
                });
            }
            if(select==1){
                Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.score-o2.score;
                    }
                });
            }
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i).name+" "+list.get(i).score);
            }
        }
    }
}