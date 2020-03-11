public class 程序的所有状态 {
    public static void main(String[] args) {
        //State是枚举类型,遍历枚举所有可选项
        Thread.State[] values = Thread.State.values();
        for(Thread.State state:values){
            System.out.println(state);
        }
    }
}
