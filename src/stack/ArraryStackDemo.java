package stack;

import java.util.Scanner;

/**
 * @author zhoukx
 * @date 2019/11/30
 * @description 数组模拟栈
 */
public class ArraryStackDemo {
    public static void main(String[] args) {
        //测试ArrayStack 是否正确
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        //控制退出
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈（入栈）");
            System.out.println("pop:表示从栈取出数据（出栈）");
            System.out.println("请输入你的选择");
            String next = scanner.next();
            switch (next){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int i = scanner.nextInt();
                    stack.push(i);
                    break;
                case "pop":
                    try {
                        int pop = stack.pop();
                        System.out.printf("取出的数据时%d",pop);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    break;

                case "exit":
                    scanner.close();
                    loop = false;
                    break;


            }

        }
        System.out.println("程序退出了！！");
    }

}
class ArrayStack{
    /**
     * 栈大小
     */
    private  int maxSize;
    /**
     * 数组，数组模拟栈，数据放在数组
     */
    private int[] stack;
    /**
     * 栈顶  初始化为-1
     */
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new  int[maxSize];
    }

    /**
     * 栈满
     */
    public boolean isFull(){
        return  top == maxSize -1;
    }

    /**
     * 栈空
     */
    public boolean isEmpty(){
        return  top == -1;
    }

    /**
     * 入栈操作
     */
    public void push(int value){
        // 判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈操作   将栈顶的数据返回
     */
    public int  pop(){
        //判断栈空
        if (isEmpty()) {
           //抛出异常来处理
            throw  new  RuntimeException("栈空");
        }
        //返回数据
        int value = stack[top];
        top -- ;
        return value;
    }

    /**
     * 遍历栈   遍历从栈顶开始显示数据
     */
    public void list(){

        //判断是否为空
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
        return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

}