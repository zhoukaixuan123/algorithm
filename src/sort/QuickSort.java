package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhoukx
 * @date 2020/1/3
 * @description 快速排序法
 */
public class QuickSort {

    public static void main(String[] args) {
       // int [] arr = {-9,78,0,23,-567,70};
        int arr[] =  new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前");
        System.out.println(format);

        quickSort(arr,0,arr.length-1);


        Date date2 = new Date();
        String format2 = simpleDateFormat.format(date2);
        System.out.println("排序的数组");
        System.out.println(format2);
       // System.out.println(Arrays.toString(arr));
    }

    public static  void quickSort(int [] arr ,int left,int right){
        // 左下标
        int l = left;
        // 右下表
        int r = right;
        // pivot 中轴值
        int  pivot = arr[(left+right)/2];
        // 临时变量
        int  temp = 0;
        // while 循环的目的是比pivot 值小放到左边
        // 比pivot 值大的放到右边
        while (l<r){
            // pivot 的左边一直找，找到一个大与等于pibot值 才退出
           while (arr[l] < pivot){
              l+=1;
           }
            // pivot 的右边一直找，找到一个大小于provd值 才退出
            while (arr[r] > pivot){
                r -=1;
            }
            // 如果l>= r 说明pivot的左右的值，已经按照左边全部是
            // 小于等于pivot值，右边全部大于等于pivot的值
            if(l >= r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] =arr[r];
            arr[r] = temp;
            //如果交换完成后，发现这个arr[l] == pivot 值相等  前移
            if(arr[l] == pivot){
                r -= 1 ;
            }
            // 如果交换完后，发现这个arr[r] == pivot 值相等 l++ ,后移
            if(arr[r] == pivot){
                l += 1;
            }
        }
        // 如果 l== r ，必须l++ ，r-- 否则栈溢出
        if(l == r){
             l +=1;
             r -=1;
        }
        // 向左递归
        if (left < r){
            quickSort(arr,left ,r );
        }
        // 向右递归
        if (right > l){
            quickSort(arr,l ,right );
        }

       // System.out.println(Arrays.toString(arr));
    }
}
