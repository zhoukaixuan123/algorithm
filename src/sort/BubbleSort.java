package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zhoukx
 * @date 2019/12/29
 * @description 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
       // int arr[] = {3,9,-1,10,20};
        int arr[] =  new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*80000);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前");
        System.out.println(format);

        bubbleSort(arr);
        Date date2 = new Date();
        String format2 = simpleDateFormat.format(date2);
        System.out.println("排序的数组");
        System.out.println(format2);

    }

    /**
     *     冒泡封装
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        // 第一趟排序
        // 临时变量
        int temp = 0;
        // 表示 是否进行过交换
        boolean flag = false;
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-1-i ; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j+1]) {
                    flag = true;
                    temp = arr [j];
                    arr[j] = arr [j+1];
                    arr[j+1] = temp;
                }
            }
            //  一次交换都没有发生
            if (!flag) {
                 break;
            }else {
                //  充值flag  进行下次判断
                flag = false;
            }
        }
    }
}
