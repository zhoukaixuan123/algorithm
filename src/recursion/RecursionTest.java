package recursion;

/**
 * @author zhoukx
 * @date 2019/12/1
 * @description 递归调用
 */
public class RecursionTest {

    public static void main(String[] args) {
        test(4);
        int factorial = factorial(3);
        System.out.printf("阶乘：%d",factorial);
    }
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }else {
            System.out.println("n=" + n);
        }

    }

    /**
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            //factorial(3 - 1) * 3
            //factorial(2)* 2 * 3
            //factorial(1)* 2 * 3

            return factorial(n - 1) * n;
        }
    }

}
