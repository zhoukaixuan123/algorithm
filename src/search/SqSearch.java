package search;

/**
 * @author zhoukx
 * @date 2020/1/17
 * @description 查找算法
 *    线性查找
 */
public class SqSearch {

    public static void main(String[] args) {
        int arr[] = {1,9,11,-1,34,89};
        int index = seqSearch(arr,11 );
        if (index == -1) {
            System.out.println("没有找到");
        }else{
            System.out.println("找到了"+index);
        }
    }

    /**
     *   这里哦我们实现的查找是找到一个满足条件就返回
     * @param arr
     * @param value
     * @return
     */
    public static  int seqSearch(int []arr,int value) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
