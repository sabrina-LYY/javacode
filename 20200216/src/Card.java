import java.util.Arrays;
import java.util.Comparator;

//要排序自定义类型，必须实现Comparable接口，并重写compareTo
//缺点，不能擅自修改代码
class Person implements Comparable<Person>{
    public String name;
    public int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        //return this.age-o.age;
        return this.name.compareTo(o.name);
    }
}



class Person1 {
    public String name;
    public int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person1(String name, int age){
        this.name = name;
        this.age = age;
    }

}

class ComparatorByAge implements Comparator<Person1>{

    @Override
    public int compare(Person1 o1, Person1 o2) {
        if(o1==o2){
            return 0;
        }
        if(o1==null){
            return -1;
        }
        if(o2==null){
            return 1;
        }
        return o1.age-o2.age;
    }
}



public class Card {
    public int rank;
    public String suit;
    public Card(int rank,String suit){
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if( !(obj instanceof Card)){//如果obj不是card的实例
            return false;
        }
        Card card = (Card) obj;
        return rank==card.rank && suit.equals(card.suit);
    }


    public static void main(String[] args) {
        Person1[] people = new Person1[3];
        people[0] = new Person1("zhangfei",52);
        people[1] = new Person1("lisi",16);
        people[2] = new Person1("wangwu",32);
        ComparatorByAge comparatorByAge = new ComparatorByAge();
        Arrays.sort(people, comparatorByAge);
        System.out.println(Arrays.toString(people));

    }
    public static void main1(String[] args) {
        //Card card1
       /* Card card1 = new Card(1,"♠");
        Card card2 = new Card(1,"♠");

        System.out.println(card1==card2);
        System.out.println(card1.equals(card2));//两排相同，要重写equals方法
*/
        Person[] people = new Person[3];
        people[0] = new Person("zhangfei",52);
        people[1] = new Person("lisi",16);
        people[2] = new Person("wangwu",32);
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));

    }
}
