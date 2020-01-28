package search;

import java.util.Arrays;

/**
 * @author zhoukx
 * @date 2020/1/17
 * @description 斐波那契算法 也叫 黄金分割算法
 */
public class FibonaccSearch {

    public  static  int maxSize = 20 ;
    public static void main(String[] args) {
        int arr[] = {1,8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr, 89));
    }

    /**
     * 非递归得到一个斐波那契数列
     * @return
     */
    public  static int[] fib(){
          int [] f = new int[maxSize];
          f[0] = 1;
          f[1] =1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1]+ f[i-2];
        }
        return f;
    }

    /**
     *     斐波那契算法
     * @param arr  数组
     * @param key  我们需要查找的关键码
     * @return  返回对应下标 没有返回-1
     */
    public static  int fibSearch(int [] a,int key){
        int  low = 0;
        int high = a.length  - 1;
        // 表示斐波那契分割数值的下标
        int  k = 0;
        // 存放mid值
        int mid = 0;
        // 获取斐波那契数列
        int f[] = fib();
        // 获取到斐波那契分割数值的下标
        while (high > f[k] -1 ){
            k++;
        }
        // 因为f[k] 值可能大于a 的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向a[]
        // 不足的部门使用0填充
        int [] temp = Arrays.copyOf(a,f[k] );
        // 实际上需要使用a数组最后的数填充temp
        for (int i = high+1; i < temp.length; i++) {
            temp[i] =a[high];
        }

        // 使用while来循环处理，找到我们的数key
        while (low <= high){
            // 只要条件满足，就可以找
            mid = low+f[k-1]-1;
            // 我们应该继续想数组的前面查找（左边）
            if (key < temp[mid]){
               high = mid-1;
               //为什么是k--
                // 全部元素 = 前面的元素+ 后面元素
                // 因为前面f[k-1]个元素，所以可以继续拆分 f[k-1] = f[k-2] + f[k -3]
                // 即在f[k-1]的掐面继续查找k
                k --;
                //向数组的后面查找
            }else if (key > temp[mid]){
                low = mid + 1;
                // 说明  全部元素 = 前面元素+ 后面元素
                // f[k] = f[k-1]+f[k-2]
                // 因为后面我们有f[k-2],所以可以继续拆分f[k-1] = f[k-3]+ f[k-4]
                k -= 2;
            }else {
                if (mid <= high){
                    return  mid;
                }else {
                    return high;
                }
            }
        }
        return  -1;
    }
}
