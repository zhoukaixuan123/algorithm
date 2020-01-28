package sort;

import java.util.Arrays;

/**
 * @author zhoukx
 * @date 2020/1/5
 * @description 基数排序方法
 */
public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {53,3,542,748,14,214};
        radixSort(arr);
    }

    /**
     *  基数配组
     */
    public static  void  radixSort(int [] arr){

        // 根据前面的推导过程，我们可以得到最终的基数排序代码
        // 1 得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 0; i <arr.length ; i++) {
           if(arr[i] > max){
               max =arr[i];
           }
        }
        // 得到最大的几位数
        int maxLength =(max + "").length();


       //第一轮排序（针对每个元素的个位排序）
        // 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //1、二维数组包含10个一维数组
        //2. 位了防止放入数的时候，数据一处，则每个一维数组（桶）大小定位arr.length
        int [][] bucket = new  int[10][arr.length];
        // 为了记录每个桶中，实际存放多少个数据，我们定义一个一维数组来记录个个桶的每次放入的数据个数
        // 可以这样理解 bucketElement[0],记录就是bucket[0]桶放入数据的个数
        int[] bucketElementCounts = new int [10];


        // 循环处理
        for (int i = 0,n =1; i < maxLength; i++,n*=10) {
            // 第一次个位 第二次十位 依次类推
            for (int j = 0; j <arr.length ; j++) {
                // 去除每个元素的个数
                int digitOfElement = arr[j]/n%10;
                // 放到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 按照这个桶的顺序（一维数组的下标一次去除数据，放入原来数组）
            int index = 0;
            for (int k = 0; k <bucketElementCounts.length ; k++) {
                // 如果桶中，有数据我们才能放到元数据组
                if (bucketElementCounts[k] != 0){
                    // 循环该桶即第k个桶（即第K个一维数组）放入
                    for (int l = 0; l < bucketElementCounts[k] ; l++) {
                        // 去除元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                // 第i++轮处理后，需要将bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }
            System.out.println("第一轮对个位数组排序处理="+ Arrays.toString(arr));

        }

//        // 第一轮（针对每个元素的个位进行排序处理）
//        for (int j = 0; j <arr.length ; j++) {
//            // 去除每个元素的个数
//            int digitOfElement = arr[j]%10;
//            // 放到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        // 按照这个桶的顺序（一维数组的下标一次去除数据，放入原来数组）
//        int index = 0;
//        for (int k = 0; k <bucketElementCounts.length ; k++) {
//            // 如果桶中，有数据我们才能放到元数据组
//            if (bucketElementCounts[k] != 0){
//                // 循环该桶即第k个桶（即第K个一维数组）放入
//                for (int l = 0; l < bucketElementCounts[k] ; l++) {
//                    // 去除元素放入到arr
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            // 第一轮处理后，需要将bucketElementCounts[k] = 0
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第一轮对个位数组排序处理="+ Arrays.toString(arr));
//
//
//        System.out.println("======================");
//        // 第2轮（针对每个元素的个位进行排序处理）
//        for (int j = 0; j <arr.length ; j++) {
//            // 去除每个元素的个数
//            int digitOfElement = arr[j]/10%10;
//            // 放到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        // 按照这个桶的顺序（一维数组的下标一次去除数据，放入原来数组）
//         index = 0;
//        for (int k = 0; k <bucketElementCounts.length ; k++) {
//            // 如果桶中，有数据我们才能放到元数据组
//            if (bucketElementCounts[k] != 0){
//                // 循环该桶即第k个桶（即第K个一维数组）放入
//                for (int l = 0; l < bucketElementCounts[k] ; l++) {
//                    // 去除元素放入到arr
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            // 第一轮处理后，需要将bucketElementCounts[k] = 0
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第一轮对个位数组排序处理="+ Arrays.toString(arr));
//
//
//        System.out.println("=================================");
//
//        // 第一轮（针对每个元素的个位进行排序处理）
//        for (int j = 0; j <arr.length ; j++) {
//            // 去除每个元素的个数
//            int digitOfElement = arr[j]/10/10%10;
//            // 放到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        // 按照这个桶的顺序（一维数组的下标一次去除数据，放入原来数组）
//        index = 0;
//        for (int k = 0; k <bucketElementCounts.length ; k++) {
//            // 如果桶中，有数据我们才能放到元数据组
//            if (bucketElementCounts[k] != 0){
//                // 循环该桶即第k个桶（即第K个一维数组）放入
//                for (int l = 0; l < bucketElementCounts[k] ; l++) {
//                    // 去除元素放入到arr
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            // 第一轮处理后，需要将bucketElementCounts[k] = 0
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第3轮对个位数组排序处理="+ Arrays.toString(arr));
    }
}
