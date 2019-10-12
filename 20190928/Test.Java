/*
1.class--定义类，后面Test为类名。在.java文件中，只能有一个public修饰的类，类名一定要和文件名相同。
2.class{类体（属性  方法）}
3.main函数/方法
4.public static？？？为什么main 方法要被static修饰？？？
5.static 静态的。java 中static作用很多
6.String[] args---->定义数组（字符串数组）
   String--字符串类型
7.println--->输出且换行 
  print（）--->输出（没有换行）
  printf（%d\n,a）
8.window（GBK编码）
  Linux  （UTF-8编码）
9.javac -encoding UTF-8 文件名.java
10. 数组长度可直接为:数组名.length
	for(i=0;i<args.length;i++){
			System.out.println("args[i]");
11.一个类生成一个.class文件
   一个类对应一个字节码文件
*/



class Test2{
	
}
public class Test{
	public static void main1(String[] args){
		for(int i=0;i<args.length;i++){
			System.out.println("args[i]");
		}
		System.out.println("hello,java!");
		
	}
}