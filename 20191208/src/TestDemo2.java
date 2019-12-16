import java.util.ArrayList;
import java.util.List;


public class TestDemo2 {

    //杨辉三角
    //numRows  行数
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle  = new ArrayList<>();
        if(numRows == 0){
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);//把1加到第0行
        for(int i=1;i<numRows;i++){
            List<Integer> curRow = new ArrayList<>();//当前行
            curRow.add(1);
            //上一行
            List<Integer> prevRow = triangle.get(i-1);
            //第i行的第j列
            for(int j=1;j<i;j++){
                int tmp = prevRow.get(j)+ prevRow.get(j-1);
                curRow.add(tmp);
            }
            curRow.add(1);
            triangle.add(curRow);
        }

        return triangle;
    }
    public static void main(String[] args) {
        List<List<Integer>> ret = generate(5);
        for(List<Integer> list:ret){//foreach (元素类型：遍历的对象)
            System.out.println(list);
        }

    }


    //判断str1中是否包含str2，如果有则删除
    public static List<Character> func(String str1,String str2){//返回值是list中放的Character类型
        List<Character> ret = new ArrayList<>();
        for(int i=0;i<str1.length();i++){
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")){
                ret.add(ch);
            }
        }
        return ret;
    }

    public static void main2(String[] args) {
        List<Character> list =  func("welcome to bit","come");
        Object[] obj = list.toArray();
        System.out.println();
    }


    public static void main1(String[] args) {
        List<Student> list = new ArrayList<>();
        Student student1 = new Student("zhangsan","18",56);
        Student student2 = new Student("caocao","20",85);
        Student student3 = new Student("lisi","81",45);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        //System.out.println(list);
        for(Student student:list){
            System.out.println(student);
        }

    }
}
class Student {
    public String name;
    public String classes;
    public double score;
    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}
