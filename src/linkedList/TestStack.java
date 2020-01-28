package linkedList;

import java.util.Stack;

/**
 * @author zhoukx
 * @date 2019/11/25
 * @description 栈的基本使用
 */
public class TestStack {

    public static void main(String[] args) {
        Stack<String> objects = new Stack<>();
        objects.add("jack");
        objects.add("tom");
        objects.add("smith");
        while (objects.size() > 0){
            System.out.println(objects.pop());
        }
    }
}
