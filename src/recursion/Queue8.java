package recursion;

/**
 * @author zhoukx
 * @date 2019/12/1
 * @description 八皇后问题  回溯算法
 */
public class Queue8 {

    //定义一个max表示共有多少个皇后
    int max = 8;
    // 定义数组array,保存皇后放置的结果，比如 arr ={0，4，7，8，2，6，1，3}
    int[] array = new int[max];

    static int count = 0;
    public static void main(String[] args) {
        // 测试8皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法",count);
    }

    /**
     *  编写一个方法，放置第n个皇后
     *   注意：check  每一次递归时进入到check 方法，都有 for (int i = 0; i <max ; i++) {
     */
    public void check(int n){
        // n = 8 ,其实8个皇后已经放好了
        if (n == max) {
            print();
            return;
        }
        // 依次放入皇后 判断是否冲突
        for (int i = 0; i <max ; i++) {
            // 先把当前这个皇后n,放到该行的第1列
            array[n] = i ;
            //判断当放置 第n个皇后到i列时，是否冲突
            // 不冲突
            if (judge(n)){
                // 接着放n+1 个皇后，即开启递归
                check(n+1);
            }
            // 如果冲突，就继续执行array[n] = i; 即将第n个环保过后，防止在本行后移一个位置
        }

    }


    /**
     * 查看我们放置第n个皇后，就去检测该皇后和前面已经摆放的皇后冲突
     * @param n  第n个皇后
     * @return
     */
    private  boolean judge(int n){
        for (int i = 0; i < n ; i++) {
            //  说明  array[i] == array[n] 表示判断第n个皇后和前免的n-1个皇后在同一列
            //Math.abs(n-i) == Math.abs(array[n]-array[i])  表示第n个皇后和第i个皇后是否在同一个斜线
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i]) ){
                return  false;
            }
        }
        return true;
    }

    /**
     *   写一个方法是，可以将皇后摆放的位置输出
     */
    private  void print(){
        count++;
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
