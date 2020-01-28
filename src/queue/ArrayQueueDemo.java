package queue;

import java.util.Scanner;

/**
 * @author zhoukx
 * @date 2019/11/21
 * @description 数组模拟demo
 * 模拟队列思路
 * 当我们将数据存入队列时称为”addQueue”，addQueue 的处理需要有两个步骤：思路分析
 * 将尾指针往后移：rear+1 , 当front == rear 【空】
 * 若尾指针 rear 小于队列的最大下标 maxSize-1，则将数据存入 rear所指的数组元素中，否则无法存入数据。 rear  == maxSize - 1[队列满]
 *
 *   问题：
 *      虽然取出了数据但是，数组还是在被占用，队列不能重复使用
 *
 *
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        //测试队列
        //创建对象
        ArrayQueue arrayQueue = new ArrayQueue(3);
        //接受用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数组");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int queue = arrayQueue.getQueue();
                        System.out.println("取出的数据是："+queue);
                    }catch(Exception e){
                        e.printStackTrace();
                    }finally{

                    }
                    break;
                case 'h':
                    try{
                        int queue = arrayQueue.headQueue();
                        System.out.println("取出队列头的数据是："+queue);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                        break;
            }

        }
        System.out.println("程序退出！！");
    }
}

/**
 * 使用数组模拟队列，编写一个ArraryQueue类
 */
class ArrayQueue {
    //数组最大容量
    private int maxSize;

    //队列头
    private int front;

    //队列尾
    private int rear;

    //用于存放数据，模拟队列
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //指向队列头部，分析出front使指向队列的前一个位置
        front = -1;
        //指向队列的尾部，指向队列尾部的数据（就是队列的最后一个数据）
        rear = -1;
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     *
     * @param front
     */
    public void addQueue(int front) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        //rear 后移
        rear++;
        arr[rear] = front;
    }

    /**
     * 获取队列的数据
     *
     * @return
     */
    public int getQueue() {

        //判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        //队列头往后移
        front++;
        return arr[front];
    }

    /**
     * 显示所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空的，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 显示队列的头数据，注意不是去除数据
     *
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front + 1];
    }
}