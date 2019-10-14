//交换两个整数的值

/*public class test{
	public static void main(String[] args){
		int[] array = {1,2};
		swap(array);
		System.out.println("a="+array[0]);
		System.out.println("b="+array[1]);
	}
public static void swap(int [] array){
	int tmp = array[0];
	array[0] = array[1];
	array[1] = tmp;
	}
}*/

//求三个变量中的最大最小值
/*public class test{
	public static void main(String[] args){
		int max = 0;
		int min = 0;
		int a=10;
		int b=4;
		int c=6;
		max=Max(a,b,c);
		min=Min(a,b,c);
		System.out.println("max="+ max);
		System.out.println("min="+ min);
	}
	
	public static int Max(int a,int b,int c){
		if(a>=b && a>=c)
			return a;
		if(b>=a && b>=c)
			return b;
		return c;
		
	}
	public static int Min(int a,int b,int c){
		if(a<=b && a<=c)
			return a;
		if(b<=a && b<=c)
			return b;
		return c;
		
	}
}
*/

//1. 根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
/*import java.util.Scanner;
public class test{
	public static void main(String[] args){
		Scanner num = new Scanner(System.in);
		int i = num.nextInt();
		System.out.print("请输入年龄：");
		if(i > 0 && i <= 18)
			System.out.print("少年！");
		else if(i >= 19 && i <= 28)
			System.out.print("青年！");
		else if(i >= 29 && i <= 55)
			System.out.print("中年！");
		else
			System.out.print("老年！");
		
	}
}
*/

//2. 判定一个数字是否是素数
/*import java.util.Scanner;
public class test{
	public static void main(String[] args){
		Scanner num = new Scanner(System.in);
		int i = num.nextInt();
		int n = prime(i);
		if(n == 1){
			System.out.println(i+"是素数");
		}
		else{
			System.out.println(i+"不是素数");
		}
		}
	
	public static int prime(int i){
		for(int j=2;j<i;j++){
			if(i%j==0){
				return 0;
				}
			}
			return 1;
		}
	}
	*/




//1234按位打印
/*public class test{
	public static void main(String[] args){
		int i = 1234;
		func(i);
	}
	public static void func(int i){
		if (i > 9){
			func(i/10);
		}
		System.out.print(i%10+" ");
	}
}
*/

/*计算1+2+3+4+5+6+7+8+9+10
public class test{
	public static void main(String[] args){
		int num=10;
		int sum=Sum(num);
		System.out.println("sum= "+sum);
	}
	public static int Sum(int num){
		if(num == 1)
			return 1;
		return num+ Sum(num-1);
		
		
		
	}
}
*/
//例如1729 应该返回1+7+2+9，和是19
/*public class test{
	public static void main(String[] args){
		System.out.println(func(1729));
	}
	public static int func(int num){
		if(num<=9){
			return num;
		}
		return num%10+func(num/10);
	}
}
*/

//青蛙跳台
/*import java.util.Scanner;
public class test{
	public static void main(String[] args){
		Scanner num = new Scanner(System.in);
		int i = num.nextInt();
		System.out.println(func(i));
	}
	
	public static int func(int i){
		if(i == 1){
			return 1;
		}
		else if(i == 2){
			return 2;
		}
		return func(i-2) + func(i-1);
	}
}*/

//3.  1到100以内的素数
/*public class test{
	public static void main (String[] args){
		int i=0;
		int j=0;
		for(i=2;i<=100;i++){
			int flag = 0;
			for(j=2;j<i;j++){
				if(i%j==0){
					flag = 1;
					break;
				}
			}
			if(flag == 0){
				System.out.print(i+" ");
			}
		}
	}
}
*/
//4. 输出 1000 - 2000 之间所有的闰年
/*public class test{
	public static void main (String[] args){
		for(int i=1000;i<=2000;i++){
			if(i%4==0&&i%100!=0 ||i%400==0){
				System.out.print(i+" ");
			}
		}

	}
}
*/

//5. 输出乘法口诀表
/*public class test{
	public static void main (String[] args){
		for(int i=1;i<10;i++){
			for(int j=1;j<=i;j++){
				System.out.print(i+"*"+j+"="+i*j+" ");
			}
			System.out.println(" ");
			
		}

	}
}
*/

//6. 求两个正整数的最大公约数

/*public class test{
	public static void main (String[] args){
		int a=15;
		int b=3;
		gcd(a,b);
	}
	public static void gcd(int a,int b){
		while(true){
			int c=a%b;
			while(c!=0){
				a=b;
				b=c;
				c=a%b;
		}
			System.out.println(b);	
			break;
			}
			
		}
		
	}
*/
//7. 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。

/*public class test{
	public static void main(String[] args){
		double sum = 0D;
		for(int i=1;i<=100;i++){
			if(i%2!=0){
				sum += 1.0/i;
			}else{
				sum -= 1.0/i;
			}
		}System.out.println("sum="+sum);
	}
}
*/

//8. 编写程序数一下 1到 100 的所有整数中出现多少个数字9。
/*public class test{
	public static void main(String[] args){
		int num=0;
		for(int i=0;i<=100;i++){
			if(i%10==9||i/10==9){
				num++;
			}
		}
		System.out.println("一共有"+num+"个9");
}
}
*/
//9. 求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本
//身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)
/*public class test{
	public static void main(String[] args){
		for(int i=100;i<1000;i++){
			int a=i%10;
			int b=i/10;
			if(i==Math.pow(a,3)+Math.pow(b%10,3)+Math.pow(b/10,3)){
				System.out.print(i+" ");
			}
			
			
		}
	}
}
*/

//10. 编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输
//入，最多输入三次。三次均错，则提示退出程序
/*import java.util.Scanner;
public class test{
	public static void main(String[] args){
		int time = 0;
		for(time=1;time<=3;time++){
			System.out.println("请输入密码：");
			Scanner num = new Scanner(System.in);
			String password = num.next();
			
			if(password.equals("123456")){
				System.out.println("登陆成功！");
				break;
			}
			else{
				System.out.println("输入错误，你还有"+(3-time)+"次机会");
				
			}
		}if(time<=0){
			System.out.println("三次输入错误，退出程序");
		}
		
		
	}
}
*/
//11. 写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
/*public class test{
	public static void main(String[] args){
		int i=4;
		func(i);
	}
	public static void func(int i){
		int count = 0;
		while(i>0){
			if(i%2==1){
				count++;
			}
			i=i/2;
		}System.out.println(count);
	}
}

*/
//12. 获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列。

public class test{
	public static void main(String[] args){
		int num=4;
		func(num);
	}
	public static void func(int num){
		int i=0;
		
		System.out.println("奇数位");
		for(i=31;i>=0;i-=2){
			int a=(num>>i&1);
			System.out.print(a+" ");
		}
		System.out.println(" ");
		System.out.println("偶数位");
		for(i=30;i>=0;i-=2){
			int a=(num>>i&1);
			System.out.print(a+" ");
		}
		
		
	}
}
//13. 输出一个整数的每一位.
/*public class test{
	public static void main(String[] args){
		int i=1234;
		func(i);
	}
	
	public static void func(int i){	
		if(i>9){
			func(i/10);
		}
		System.out.print(i%10+" ");
	}
}
*/
//14. 完成猜数字游戏
/*import java.util.Scanner;
import java.util.Random;
public class test{
	public static void main(String[] args){
		Random df = new Random();
		int i = df.nextInt(101);
		while(true){
			Scanner num = new Scanner(System.in);
			int input = num.nextInt();
			if(i>input){
				System.out.println("猜小了！");
				continue;
			}
			else if(i<input){
				System.out.println("猜大了！");
				continue;
			}
			else{
				System.out.println("猜对啦");
				break;
			}
		}
	}
}
*/




