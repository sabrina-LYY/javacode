/*
1. 是不是线程安全?  看是否有共享，是否有修改
2.如何改成线程安全？size都会抢，所以在有size的地方加锁,take和put只能进行一个
* 不可以加volatile，有size++，要保证原子性
3.生产者在队列满时等待，消费者在队列空时等待。用wait
4.生产者需要唤醒可能在等的消费者，消费者需要唤醒可能在等的生产者。
*/

import java.util.Scanner;

public class MyBlockingArrayQueue {
    int [] array = new int[1];
    int front =0;//只有消费者修改
    int rear = 0;//只有生产者修改
    int size = 0;//生产者和消费者都会修改

    //生产者才会调用put
    synchronized void put(int value) throws InterruptedException {
        while(size==array.length){
            //队列满
            //throw new RuntimeException("队列已满");
            wait();
        }
        array[rear] = value;
        rear = (rear+1) % array.length;
        size++;//要保证原子性，volatile不能保证原子性
        System.out.println(size);
        notifyAll();
    }

    //调用take的一定是消费者
    synchronized int take() throws InterruptedException {
        //空的情况
        while(size==0){
            //throw new RuntimeException("队列为空");
            wait();
        }
        int value = array[front];
        //取模，如果越界就循环回来
        front = (front+1)% array.length;

        size--;
        System.out.println(size);
        notifyAll();//notify在size--之前/后都可以，因为还没释放锁，内部什么顺序无所谓
        return value;
    }
}
