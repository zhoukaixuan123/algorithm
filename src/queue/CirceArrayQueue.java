package queue;

import java.util.Scanner;

/**
 * @author zhoukx
 * @date 2019/11/21
 * @description 数组模拟环形队列
 *
 * 尾索引的下一个为头索引时表示队列满，即将队列容量空出一个作为约定,这个在做判断队列满的时候需要注意 (rear + 1) % maxSize == front 满]
 * rear == front [空]
 *
 *
 */
public class CirceArrayQueue {

    public static void main(String[] args) {
        //测试队列
        //创建对象
        //说明这里最大队列是 4  其队列有效数据最大是 3
        CirceArray circeArray = new CirceArray(4);
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
                    circeArray.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    circeArray.addQueue(value);
                    break;
                case 'g':
                    try{
                        int queue = circeArray.getQueue();
                        System.out.println("取出的数据是："+queue);
                    }catch(Exception e){
                        e.printStackTrace();
                    }finally{

                    }
                    break;
                case 'h':
                    try{
                        int queue = circeArray.headQueue();
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

class CirceArray{
    //数组最大容量
    private int maxSize;
    //队列头  初始值是0
    private int front;
    //队列尾 的初始值是0
    private int rear;
    //用于存放数据，模拟队列
    private int[] arr;

    public  CirceArray(int  arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
     * @param n
     */
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        //直接加入数据
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1)% maxSize;
    }

    /**
     * 获取队列的数据
     *
     * @return
     */
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        // 这里需要分析出 front是指向队列的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;

    }

    /**
     * 显示所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空的，没有数据");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

        }
    }

    /**
     * 求出当前队列数据的有效个数
     */
    public int size(){
        return (rear+maxSize-front)%maxSize;
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
        return arr[front];
    }
}