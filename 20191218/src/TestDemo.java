

public class TestDemo {
    //编写代码使用 A 这个泛型类
    public static class A<T> {
        private T value;
        A(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }

    }
    public static void main1(String[] args) {
        A<String> name = new A<String>("zhangsan");
        A<Integer> age = new A<Integer>(25);
        System.out.println(name.get());
        System.out.println(age.get());
    }


    //小镇的法官
    public int findJudge(int N, int[][] trust) {
        int i=0;
        int j=0;
        int [] array = new int[N];
        int [] flg = new int[N];
        for(i=0;i<trust.length;i++){
            trust[i][0]
        }
        trust[i][0] != trust[i][1]
        1 <= trust[i][0], trust[i][1] <= N
    }


}
