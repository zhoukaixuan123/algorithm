package search;

/**
 * @author zhoukx
 * @date 2020/1/17
 * @description 插值查找算法
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int [] arr = new int [100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        int i = insertValueSearch(arr, 0, arr.length - 1, 100);
        System.out.println(i);
    }

    /**
     *
     *   插值查找算法
     * @param arr  数组
     * @param left  左边的索引
     * @param right  右边的索引
     * @param findVal  查找的值
     * @return
     */
    public static  int insertValueSearch(int [] arr,int left,int right,int findVal){
        System.out.println("调用多少次");
        // findVal< arr[0] || findVal > arr[arr.length-1]   不加 mid 可能会越界
        if (left > right || findVal< arr[0] || findVal > arr[arr.length-1]) {
            return  -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        // 向右递归
        if (findVal > midVal){
            return  insertValueSearch(arr,mid+1 ,right ,findVal );
        }else if (findVal < midVal){
            return  insertValueSearch(arr,left ,mid-1 ,findVal );
        }else {
            return mid;
        }
    }

}
