/*求两个数的最大公约数
public class HomeWork {
    public static void main(String[] args){
        int ret = func(18,24);
        System.out.println(ret);
    }
    public static int func(int a,int b){
        int tmp=0;
        while(a%b!=0){
            tmp=a%b;
            a=b;
            b=tmp;
        }return tmp;
    }
}
*/

//求1到100的所有9的个数
/*
public class HomeWork{
    public static void main(String[] args){
        int ret = func(100);
        System.out.println(ret);
        }
    public static int func(int n){
        int count=0;
      for(int i=1;i<=n;i++){
          if(i/10==9||i%10==9){
              count++;
          }
      }return count;
    }
}*/
//水仙花
/*
public class HomeWork {
    public static void main(String[] args) {
        int ret = waterFlower(100);
        System.out.println(ret);
    }
    public static int waterFlower(int n){
        for(int i=0;i<=n;i++){
            int count=0;
            int tmp=i;
            while(tmp!=0){
                count++;
                tmp/=10;
            }
            tmp = i;
            int sum = 0;
            while(tmp!=0){
                sum+=Math.pow(tmp%10,count);
                tmp/10;

            }
        }
    }
}*/




import java.util.Scanner;

//输入三次密码
/*
public class HomeWork{
    public static void main(String[] args){
        func();
    }
    public static void func(){
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        while(count!=0){
            System.out.println("请输入密码：");
            String password = scanner.nextLine();
            if("abcde".equals(password)){             //java中两个字符串相等用“.equals”
                System.out.println("密码正确");
                break;
            }else{
                System.out.println("密码错误");
                count--;
            }

        }

    }
}

*/
//计算0~999999之间所有水仙花数
public class HomeWork{
    public static void main(String[] args){
        Flower(999);
    }
    public static void Flower(int n){
        for(int i=0;i<=n;i++) {
            int count=0;
            int tmp = i;
            while (tmp != 0) {
                count++;
                tmp /= 10;
            }
            tmp = i;     //上一个while循环已经把tmp除到个位数，这个语句是把tmp还原到i
            int sum = 0;
            while (tmp != 0) {
                sum += Math.pow(tmp % 10, count);
                tmp = tmp/10;
            }
            if(sum==i){
                System.out.println(i);
            }
        }
    }
}