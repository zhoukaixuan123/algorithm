package sparsearry;

/**
 * @author zhoukx
 * @date 2019/11/19
 * @description 稀疏数组算法应用场景，与实现
 */
public class SpareArrary {

    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0 表示没有棋子   1 表示黑子  2表示  蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[0][1] = 2;

        //输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组装成  稀疏数组的
        //先便利二维数组 得到非0数组的个数
        int  sum = 0 ;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j <11 ; j++) {
                if(chessArr1[i][j] != 0 ){
                    sum++;
                }
            }
        }
        System.out.println(sum);



        //创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        //第一行数组
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;


        //遍历二维数组，将非o的数据存在稀疏数组中
        //count 用于记录第几个非0的数组
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j <11 ; j++) {
                if(chessArr1[i][j] != 0 ){
                    count ++ ;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] =  j;
                    sparseArr[count][2] =  chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组的值
        System.out.println();
        System.out.println("得到的稀疏数组的为--------");


        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();

        System.out.println("稀疏数组恢复为原始数据，一下-------");

        /**
         *  1.先读取稀疏数组的第一行数据，创建二维数组
         *
         */
        int [][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        /**
         *  2.在读出稀疏数组的后几行数据，并赋值给原始的二维数组
         *  (从第二行开始进行遍历)
         */
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2] ;
        }
        //输出恢复后的二维数组
        System.out.println("输出恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }




}
