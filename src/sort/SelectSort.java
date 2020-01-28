package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zhoukx
 * @date 2019/12/29
 * @description 选择排序算法
 */
public class SelectSort {


    public static void main(String[] args) {
       // int arr[] = {101, 34, 119, 1};
        int arr[] =  new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前");
        System.out.println(format);


        selectSort(arr);
        Date date2 = new Date();
        String format2 = simpleDateFormat.format(date2);
        System.out.println("排序的数组");
        System.out.println(format2);
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        //使用逐步推导的方式
        // 原始属于组 101 34 119 1
        for (int j = 0; j < arr.length - 1; j++) {
            int minIndex = j;
            int min = arr[j];
            for (int i = j + 1; i < arr.length; i++) {
                // 如果不是最小值
                if (min > arr[i]) {
                    // 重置 min
                    min = arr[i];
                    // 重置 minIndex
                    minIndex = i;
                }
            }
            // 将最小值，放在arr[0],即交换
            arr[minIndex] = arr[j];
            arr[j] = min;
        }

    }
}


