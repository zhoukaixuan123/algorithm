package stack;

/**
 * @author zhoukx
 * @date 2019/11/30
 * @description 模拟计算器
 */
public class Caalculator {

    public static void main(String[] args) {
        String expression = "6/1+4*6-5";
        //创建两个栈，数栈和符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        //用于扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        //将每次扫描的到char保存到ch
        char ch = ' ';
        //用于拼接多位数
        String keepNum ="";
        //开始while循环的扫描expression
        while (true) {
            //依次得到expression  的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //  判断ch是什么，然后作相应的处理
            if (operStack.isOper(ch)) {
                //如果是运算府
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符，进行比较，如果当前的操作符的优先级
                    //小于或者等于栈中的操作符，就需要从数栈中pop出两个数
                    //从符号栈中pop出一个符号，进行运算，将得到结果，入
                    //数栈，然后将当前的操作符入符号栈
                    if (operStack.priotity(ch) <= operStack.priotity(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算的结果入数栈
                        numStack.push(res);
                        // 将符号入栈
                        operStack.push(ch);
                    }else{
                        //如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                } else {
                    // 如果为空直接入栈
                    operStack.push(ch);
                }
            }else {
                //如果是数，则直接入数栈
                //numStack.push(ch -48);
                //当处理是多位数时，不能发现时一个数直接入栈，因为他可能时多位数
                // 在处理数，需要向express 的表达式的index，后在看一位，
                //如果是数就进行扫描，如果是符号才入栈
                // 因此我们需要定义一个变量  字符串，用于拼接
                keepNum += ch;
                //判断下一位字符是不是数子，如果是数字，就继续扫描，如果是运算符
                //就入栈
                //注意是看后一位，不是index
                //如果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length()-1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    if (operStack.isOper(expression.substring(index+1, index+2).charAt(0))) {
                        // 如果后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //  重要！！！  keepNum清空
                        keepNum = "";
                    }
                }

            }
            //让index+1 并判断是否扫描到expression最后
            index ++;
            if (index>=expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕，就书讯从数栈和符号栈中pop出相应的数和符号，并运行
        while (true) {
            //如果符号栈为空，则计算到最后的结果，数栈中只有一个数字结果
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2 ,oper );
            //入栈
            numStack.push(res);
        }
        System.out.printf("表达式%s =%d",expression,numStack.pop());
    }

}

class ArrayStack2 {
    /**
     * 栈大小
     */
    private int maxSize;
    /**
     * 数组，数组模拟栈，数据放在数组
     */
    private int[] stack;
    /**
     * 栈顶  初始化为-1
     */
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 栈满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 返回栈顶 方法 但是并不出占
     */
    public int peek() {
        return stack[top];
    }


    /**
     * 入栈操作
     */
    public void push(int value) {
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
    public int pop() {
        //判断栈空
        if (isEmpty()) {
            //抛出异常来处理
            throw new RuntimeException("栈空");
        }
        //返回数据
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 遍历栈   遍历从栈顶开始显示数据
     */
    public void list() {

        //判断是否为空
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    /**
     * 返回运算符的优先级，优先级是程序员来定的
     * 优先级使用数字表示，数字越大优先级越高
     */
    public int priotity(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            //假定目前表达式只有 + - * /
            return -1;
        }
    }

    /**
     * 判断是不是一个运算符
     *
     * @param var
     * @return
     */
    public boolean isOper(char var) {
        return var == '+' || var == '-' || var == '*' || var == '/';
    }

    /**
     * 计算
     *
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
             default:
                 break;
        }
        return res;
    }
}