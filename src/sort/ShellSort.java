package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zhoukx
 * @date 2019/12/29
 * @description 希尔排序法
 */
public class ShellSort {

    public static void main(String[] args) {
     //   int arr[] = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int arr[] =  new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前");
        System.out.println(format);


        //shellSort(arr);
        shellSort2(arr);

        Date date2 = new Date();
        String format2 = simpleDateFormat.format(date2);
        System.out.println("排序的数组");
        System.out.println(format2);
        //System.out.println("希尔排序："+ Arrays.toString(arr));

    }

    /**
     * 希尔排序法
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        // 希尔排序第一轮排序
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //  因为第1轮排序，是将10个数据分成5组
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素（共5组，每组有2个元素），步长5
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            // System.out.println("希尔排序："+ Arrays.toString(arr));
        }


        //  因为第1轮排序，是将10个数据分成5组
//        for (int i = 5; i < arr.length; i++) {
//            // 遍历各组中所有的元素（共5组，每组有2个元素），步长5
//            for (int j = i-5; j >= 0 ; j -= 5) {
//                // 如果当前元素大于加上步长后的那个元素，说明交换
//                if (arr[j] > arr[j+5]) {
//                    temp = arr[j];
//                    arr[j] = arr[j+5];
//                    arr[j+5] = temp;
//                }
//            }
//        }
//        System.out.println("希尔排序："+ Arrays.toString(arr));


//        //  因为第1轮排序，是将10个数据分成5组
//        for (int i = 2; i < arr.length; i++) {
//            // 遍历各组中所有的元素（共5组，每组有2个元素），步长5
//            for (int j = i-2; j >= 0 ; j -= 2) {
//                // 如果当前元素大于加上步长后的那个元素，说明交换
//                if (arr[j] > arr[j+2]) {
//                    temp = arr[j];
//                    arr[j] = arr[j+2];
//                    arr[j+2] = temp;
//                }
//            }
//        }
//        System.out.println("2组希尔排序："+ Arrays.toString(arr));
//
//
//        //  因为第1轮排序，是将10个数据分成5组
//        for (int i = 1; i < arr.length; i++) {
//            // 遍历各组中所有的元素（共5组，每组有2个元素），步长5
//            for (int j = i-1; j >= 0 ; j -= 1) {
//                // 如果当前元素大于加上步长后的那个元素，说明交换
//                if (arr[j] > arr[j+1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//        System.out.println("3组希尔排序："+ Arrays.toString(arr));
    }


    /**
     * 希尔排序优化   -> 移位法
     */
    public static void shellSort2(int[] arr) {
        // 增量gap 并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，诸葛对所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        // 移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    // 当退出while后，就给temp 找到插入的位置
                    arr[j] = temp;
                }
            }
        }
        //System.out.println("希尔排序："+ Arrays.toString(arr));

    }
}
