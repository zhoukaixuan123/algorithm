package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zhoukx
 * @date 2020/1/3
 * @description 归并排序
 */
public class MergetSort {

    public static void main(String[] args) {
       // int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
        int arr[] =  new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前");
        System.out.println(format);


        // 归并需要额外的空间
        int temp []= new int[arr.length];
        mergeSort(arr,0 ,arr.length-1 ,temp );
       // System.out.println("归并排序后："+ Arrays.toString(arr));



        Date date2 = new Date();
        String format2 = simpleDateFormat.format(date2);
        System.out.println("排序的数组");
        System.out.println(format2);
    }

    /**
     *   分+和 方法
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static  void mergeSort(int [] arr,int left,int right,int[]temp){
       if(left < right){
           //中间索引
           int mid = (left + right)/2;
           // 向左递归进行分解
           mergeSort(arr,left ,mid ,temp  );
           // 向右递归
           mergeSort(arr,mid+1 ,right ,temp  );
           // 到合并
           merge(arr,left ,mid ,right ,temp );

       }

    }


    /**
     * 合并的方法
     *
     * @param arr   排序数组
     * @param left  左边有序序列的厨师索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  中转的数据
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        // 左侧的有序序列的初始索引
        int i = left;
        // 初始化j，右边的有序序列初始索引
        int j = mid + 1;
        // 指向temp数组的当前索引
        int t = 0;
        //(1)
        // 先把左右两边的数据按照规则填充到temp数组
        // 知道左右两边的有序序列，有一边处理完毕为止
        while ( i <= mid && j<= right){
            // 如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            // 即将左边的当前元素，拷贝到temp数组中
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t += 1;
                i +=1;
            }else {
                // 反之 将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //(2)
        // 把剩余数据的一边的数据依次全部填充到temp
        // 说明左边的有序序列还要有剩余的元素，就全部填充到temp
        while (i <= mid){
            temp[t] = arr[i];
            t +=1;
            i += 1;
        }
        // 说明右边的有序序列还要有剩余的元素，就全部填充到temp
        while (j <= right){
            temp[t] = arr[j];
            t +=1;
            j += 1;
        }
        //(3)
        // 将temp数组拷贝到arr中
        // 注意并不是每次都拷贝所有
        t = 0 ;
        int templeft = left;
        //第一次合并templeft ，right = 1
        while (templeft <= right){
            arr[templeft] = temp[t];
            t += 1;
            templeft += 1;
        }
    }
}
