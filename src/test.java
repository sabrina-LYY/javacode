/*
public class test {
    public static void main(String[] args){
        int SumOdd = 0;
        int SumEve = 0;
     for(int i=0;i<=100;i++){
         if(i%2==0) {
             SumOdd += i;
         }else{
             SumEve+=i;
         }
     }
     System.out.println("SumOdd="+SumOdd);
     System.out.println("SumEve="+SumEve);
    }
}


//求n的阶乘
public class test{
    public static void main(String[] args){
        int ret = func(5);
        System.out.println(ret);
    }

    public static int func(int i){
        if(i==1){
            return i;
        }
        return i*func(i-1);
    }
}


//求1！+2！+3！+4！+5！
public class test{
    public static void main(String[] args){
        int sum=0;
        for(int i=1;i<=5;i++) {
            int ret = func(i);
            sum+=ret;
        }
        System.out.println(sum);
    }

    public static int func(int i){
        if(i==1){
            return i;
        }
        return i*func(i-1);
    }
}


//交换两个整型变量   注意：不能直接引入第三个变量来交换，与c语言有所区别
public class test{
    public static void main(String[] args){
        int[] arr = {10,20};
        Swap(arr);
        System.out.println("a="+arr[0]+" "+"b="+arr[1]);
    }
    public static void Swap(int[] arr){
        int tmp=arr[0];
        arr[0]=arr[1];
        arr[1]=tmp;
    }
}

//方法的重载
public class test{
    public static void main(String[] args){
        int a=10;
        int b=20;
        int ret = add(a,b);
        System.out.println("ret="+ret);

        double a2=10.5;
        double b2=20.5;
        double ret2 = add(a2,b2);
        System.out.println("ret2="+ret2);

        double a3=10.5;
        double b3=10.5;
        double c3=20.5;
        double ret3 = add(a3,b3,c3);
        System.out.println("ret3="+ret3);
    }

    public static int add(int a,int b){
        return a+b;
    }
    public static double add(double a,double b){
        return a+b;
    }
    public static double add(double a,double b,double c){
        return a+b+c;
    }

}

//递归打印出一个数字的每一位如1234打印出来1 2 3 4
public class test{
    public static void main(String[] args){
        print(1234);
    }
    public static void print(int i){
        if(i>9) {
            print(i / 10);
        }System.out.print(i%10+" ");
    }
}


//递归求1+2+3+....+10
public class test{
    public static void main(String[] args){
        int i=10;
        int ret = add(i);
        System.out.println(ret);
    }
    public static int add(int i){
        if(i==1){
             return i;
        }return i+add(i-1);
    }
}



public class test{
    public static void main(String[] args){
        int ret=sum(1729);
        System.out.println(ret);
    }
    public static int sum(int i){
        if(i<10){
            return i;
        }return i%10+sum(i/10);
    }
}


//斐波那契数，用循环求
public class test{
    public static void main(String[] args){
        int ret = fib(50);
        System.out.println(ret);
    }
    public static int fib(int n){
        int last1 = 1;
        int last2 = 1;
        int cur=0;
        for(int i=3;i<=n;i++) {
            cur = last1 + last2;
            last1 = last2;
            last2 = cur;
        }return cur;
    }
}

//汉诺塔问题
public class test{
    public static void main(String[] args){
        Hanota(5,'A','B','C');
    }

    public static void Hanota(int i,char pos1,char pos2,char pos3){
        if(i==1){
            move(pos1,pos3);
        }else{
            Hanota(i-1,pos1,pos3,pos2);
            move(pos1,pos3);
            Hanota(i-1,pos2,pos1,pos3);
        }
    }
    public static void move(char pos1,char pos2){
        System.out.print(pos1+"-->"+pos2+"  ");
    }
}


//青蛙跳台
public class test{
    public static void main(String[] args){
        int ret = frog(5);
        System.out.println(ret);
    }
    public static int frog(int n){
        if(n==1||n==2){
            return n;
        }return frog(n-1)+frog(n-2);
    }
}*/
