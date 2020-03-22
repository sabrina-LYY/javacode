import java.io.*;

public class SerializeDemo {
    //声明实现Serializable接口，就可以实现序列化和反序列化的功能
    static class Person implements Serializable {
        String name;
        int age;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try(InputStream is = new FileInputStream("保存所有人的名单.bin")){
            try(ObjectInputStream ois = new ObjectInputStream(is)){
                Person p = (Person) ois.readObject();
                System.out.println(p.name);
                System.out.println(p.age);
                Person q = (Person)ois.readObject();
                System.out.println(q.name);
                System.out.println(q.age);

            }
        }
    }


    public static void main1(String[] args) throws IOException {
        Person p = new Person();
        p.name = "张三";
        p.age = 18;
        Person q = new Person();
        q.name = "李四";
        q.age = 25;

        try(OutputStream os = new FileOutputStream("保存所有人的名单.bin")){
            try(ObjectOutputStream oos = new ObjectOutputStream(os)){
                oos.writeObject(p);
                oos.writeObject(q);

                oos.flush();
            }
        }
    }
}
