package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoukx
 * @date 2020/1/17
 * @description 二分查找数组
 */
public class BinarySearch {


    /**
     *    二分查找必须是有序的
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = {1,8,10,89,1000,1234};
        //int resIndex = binarySearch(arr, 0, arr.length -1, 1);
        List<Integer> integers = binarySearch2(arr, 0, arr.length - 1, 10001);
        System.out.println("resindex="+integers.toString());
    }

    /**
     *   二分查找算法
     * @param arr  数组
     * @param left  左边索引
     * @param right  右边的索引
     * @param findVal  要查找的值
     * @return   如果有就返回下标 没有返回-1
     */
    public static int binarySearch(int [] arr ,int left,int right,int findVal){

        // 当left > right 时 说明没有这个数   则退出避免死递归
        if (left > right){
            return  -1;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];

        //   向右递归
        if(findVal > midVal){
           return binarySearch(arr, mid+1,right ,findVal );
           // 向左递归
        }else if (findVal < midVal){
            return binarySearch(arr, left,mid-1 ,findVal );
        }else {
            return  mid;
        }
    }


    /**
     *      如果有相同的数  则返回 所有查找值得集合
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     *
     *   思路    找到mid值 不直接返回
     *           向mid 索引值得左边扫描，将所有满足1000 的元素的下标 加入到集合中
     *            向mid 索引值得右边扫描，将所有满足1000 的元素的下标 加入到集合中
     */
    public static List<Integer> binarySearch2(int [] arr , int left, int right, int findVal){
// 当left > right 时 说明没有这个数   则退出避免死递归
        if (left > right){
            return  new ArrayList<>() ;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];

        //   向右递归
        if(findVal > midVal){
            return binarySearch2(arr, mid+1,right ,findVal );
            // 向左递归
        }else if (findVal < midVal){
            return binarySearch2(arr, left,mid-1 ,findVal );
        }else {

            //      思路    找到mid值 不直接返回
            List<Integer> reIndexList = new ArrayList<>();
            //  向mid 索引值得左边扫描，将所有满足1000 的元素的下标 加入到集合中
            int temp = mid -1 ;
            while (true){
                if (temp < 0 ||arr[temp] != findVal){
                    break;
                }
                // 否则 就temp放入到resIndexList
                reIndexList.add(temp);
                // 左移动
                temp -= 1;
            }
            reIndexList.add(mid);
            //向mid 索引值得右边扫描，将所有满足1000 的元素的下标 加入到集合中
            temp = mid +1 ;
            while (true){
                if (temp > arr.length -1 ||arr[temp] != findVal){
                    break;
                }
                // 否则 就temp放入到resIndexList
                reIndexList.add(temp);
                // 左移动
                temp += 1;
            }
            return  reIndexList;
        }
    }
}
