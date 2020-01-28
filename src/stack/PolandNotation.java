package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhoukx
 * @date 2019/11/30
 * @description 逆波兰计算器
 */
public class PolandNotation {

    public static void main(String[] args) {
        //定义逆波兰表达式
        //说明逆波兰表达式   的数字和符号使用空格隔开
        // (3+4)*5-6 => 3 4 + 5 * 6 -
        //  直接对str 进行操作不方便  因此先将1+((2+3)*4)-5 => 中缀表达式转成list
        // //3. 将得到的中缀表达式对应的List => 后缀表达式对应的List
        //		//   即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]
        String  experssion = "1+((2+3)*4)-5";
        List<String> strings = toInfixExpressionList(experssion);
        System.out.println("中缀表达式："+strings);
        List<String> list = parseSuffixExpressionList(strings);
        System.out.println("后缀表达式："+list);
        System.out.printf("后缀表达式计算结果%d",calculate(list));

//        String suufixExpression = "3 4 + 5 * 6 -";
//        //思路
//        // 1 x先将3 4 + 5 * 6 放到ArraryList中
//        //2 将ArrayList 传递给一个方法，遍历ArrayList配合栈完成计算
//        List<String> rpnList = getListString(suufixExpression);
//        System.out.println(rpnList);
//        int calculate = calculate(rpnList);
//        System.out.println("计算结果="+calculate);

    }


    /**
     *  将中缀表达转成对应的List
     */
    public static  List<String> toInfixExpressionList(String s){
        //定义一个List ，存放中缀表达式对应的内容
        List<String> list = new ArrayList<>();
        // 这是一个指针，用于遍历中缀表达式字符串
        int i = 0;
        //多位数拼接
        String str;
        //遍历到一个字符串放入到c
        char c;
        do {
            //如果c是一个非数字，我需要加入到ls
            if((c = s.charAt(i)) < 48||(c = s.charAt(i)) > 57){
                  list.add(c+"");
                  i++;
            }else {
                // 如果是一个数，需要考虑多位数
                // 先将str 置成空
                str = "";
                while(i<s.length() && (c=s.charAt(i))>=48 &&(c=s.charAt(i))<=57){
                  //拼接
                   str += c;
                   i++;
                }
                list.add(str);
            }
        }while (i<s.length());
        return  list;
    }

    /**
     * 将一个逆波兰表达式，一次将数据和运算符，放到ArrayList中
     */
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> objects = new ArrayList<>();
        for (String ele : split) {
            objects.add(ele);
        }
        return objects;
    }

    /**
     * 完成对逆波兰表达式计算
     * 从左至右扫描，将3和4压入堆栈；
     * 遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
     * 将5入栈；
     * 接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
     * 将6入栈；
     * 最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static int calculate(List<String> ls) {
        //创建栈  只需要一个即可
        Stack<String> stack = new Stack<>();
        for (String l : ls) {
            // 这里使用正则表达式取出数
            //  匹配多为数
            if (l.matches("\\d+")) {
                //入栈
                stack.push(l);
            } else {
                //pop  取出两个数进行运算  在入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (l.equals("+")) {
                    res = num1 + num2;
                } else if (l.equals("-")) {
                    res = num1 - num2;
                } else if (l.equals("*")) {
                    res = num1 * num2;
                } else if (l.equals("/")) {
                    res = num1 / num2;
                }else {
                    throw  new RuntimeException("运算符有误");
                }
                // 运算结果入栈
                stack.push(res+"");
            }

        }
        //最后留在static中的就是运算结果
        return Integer.parseInt(stack.pop());
    }

    /**
     * //3. 将得到的中缀表达式对应的List => 后缀表达式对应的List
     * 		//   即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]
     *
     */

    public static  List<String> parseSuffixExpressionList(List<String> ls){
        // 定义两个栈
        //符号栈
        Stack<String> s1 = new Stack<>();
        // 说明，因为s2这个栈，在整个转换过程中，没有出栈操作，而且后面需要我们做逆序输出
        // 因此把比较麻烦，这里我们就不用stack,直接用List<String> s2
        //Stack<String> strings2 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        // 遍历中缀表达式
        for (String itenm : ls) {
            // 如果是一个数， 加入s2
            if (itenm.matches("\\d")) {
                s2.add(itenm);
            }else if(itenm.equals("(")){
                s1.push(itenm);
            }else if(itenm.equals(")")){
                // 如果是右括号，一次弹出s1 栈顶的运算符，并且压入s2
                // 知道遇到左括号为止，此时将这对括号丢弃
                while (!s1.peek().equals("(")) {
                     s2.add(s1.pop());
                }
                //将（ 弹出s1 栈  消除小括号
                s1.pop();
            }else {
                // 当 l 的优先级小于栈运算符，将s1 栈顶的运算符弹出并
                // 压入到s2中，再次转到（4，1）与s1 中新的栈顶运算符相比较
              //问题  我们缺少一个比较优先级的方法
               while (s1.size() != 0&& Operation.getValue(s1.peek())>= Operation.getValue(itenm)){
                 s2.add(s1.pop());
               }
               //还需要将l 压入栈中
                s1.push(itenm);
            }
        }
        //将s1 中剩余的运算符一次弹出并加入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        //注意存放在list 就是 逆序 的逆波兰表达式
        return  s2;
    }

}
/**
 *  编写一个类 operation 可以返回一个运算符 对应的优先级
 */
class Operation{
    private static  int ADD = 1;
    private static  int SUB = 1;
    private static  int MUL = 2;
    private static  int DIV = 2;

    public static  int getValue(String  operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算");
                break;

        }
        return  result;
    }
}

