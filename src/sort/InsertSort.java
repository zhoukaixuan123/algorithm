package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zhoukx
 * @date 2019/12/29
 * @description 插入排序
 */
public class InsertSort {


    public static void main(String[] args) {
       // int arr[] = {101, 34, 119, 1,-1,89};
        int arr[] =  new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前");
        System.out.println(format);


        inserSort(arr);

        Date date2 = new Date();
        String format2 = simpleDateFormat.format(date2);
        System.out.println("排序的数组");
        System.out.println(format2);
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void inserSort(int[] arr) {
        // 第一轮 {101, 34, 119, 1}; =》 {34, 101, 119, 1};
        //定义带插入的数
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            // 即arr[1] 前面的这个数的下表
            int insertIndex = i - 1;
            // 给insertVal 找到插入的位置
            // 说明  给 insertIndex >= 0 保证在给insertVal 找到插入位置,不越界
            //insertVal < arr[insertIndex] 说明带插入的这个数 还没有找到插入的位置
            // 就需要将 arr[insertIndex] 后移动
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到 insertIndex+1
            // 举例：
            //  判断优化 是否需要赋值
            if(insertIndex+1 != i){
                arr[insertIndex + 1] = insertVal;
            }
        }

//        // 第二轮
//        //定义带插入的数
//         insertVal = arr[2];
//        // 即arr[1] 前面的这个数的下表
//         insertIndex = 2-1;
//        // 给insertVal 找到插入的位置
//        // 说明  给 insertIndex >= 0 保证在给insertVal 找到插入位置,不越界
//        //insertVal < arr[insertIndex] 说明带插入的这个数 还没有找到插入的位置
//        // 就需要将 arr[insertIndex] 后移动
//        while(insertIndex >= 0 && insertVal < arr[insertIndex]){
//            arr[insertIndex +1] = arr[insertIndex];
//            insertIndex--;
//        }
//        // 当退出while循环时，说明插入的位置找到 insertIndex+1
//        // 举例：
//        arr[insertIndex +1] = insertVal;
//
//        System.out.println("第二轮操作后");
//        System.out.println(Arrays.toString(arr));
//
//
//        // 第三轮
//                //定义带插入的数
//                insertVal = arr[3];
//        // 即arr[1] 前面的这个数的下表
//        insertIndex = 3-1;
//        // 给insertVal 找到插入的位置
//        // 说明  给 insertIndex >= 0 保证在给insertVal 找到插入位置,不越界
//        //insertVal < arr[insertIndex] 说明带插入的这个数 还没有找到插入的位置
//        // 就需要将 arr[insertIndex] 后移动
//        while(insertIndex >= 0 && insertVal < arr[insertIndex]){
//            arr[insertIndex +1] = arr[insertIndex];
//            insertIndex--;
//        }
//        // 当退出while循环时，说明插入的位置找到 insertIndex+1
//        // 举例：
//        arr[insertIndex +1] = insertVal;
//
//        System.out.println("第三轮操作后");
//        System.out.println(Arrays.toString(arr));


    }
}
