package recursion;

/**
 * @author zhoukx
 * @date 2019/12/1
 * @description 递归迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {
        // 先创建一个二维数组模拟迷宫
        int[][] map = new int[8][7];
        // 使用1 表示墙
        // 上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 左右置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        // 输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        // 使用递归回数 给小球找路
        //setWay(map, 1,1 );
        //输出新的地图 ,小球走过，并标识过的递归

        //  小球策略找最小路径
        setWay2(map, 1,1 );
        System.out.println("小球走过的地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回调来给小球找路
     * 1.i.j 表示从地图那个位置出发
     * 2.如果找到6，5的位置说明通路找到
     * 3. 约定： 当map[i][j] 为0 表示该点没有走过 为1 是墙  2 表示可以走  3 表示该路径已经走过，但是不通
     * 4.在走迷宫时 我们需要确定一个策略（方法）  下-> 右 -> 上 ->左  如果该点走不通在回溯
     *
     * @param map 地图
     * @param i   从哪个位置开始找
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j) {
        //通路已经找到OK
        if (map[6][5] == 2) {
            return true;
        } else {
            //如果 这个点还没有走过
            if (map[i][j] == 0) {
                //按照策略走  下-> 右 -> 上 ->左
                //  假定该点可以走通
                map[i][j] = 2;
                //向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                    // 向右走
                } else if (setWay(map, i, j + 1)) {
                    return true;
                    // 向上走
                } else if (setWay(map, i-1, j)) {
                    return true;
                    //向左走
                } else if (setWay(map, i, j-1)) {
                    return true;
                }else{
                    // 说明该点不通是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {
                // 如果 map[i][j] != 0  可能时1，2,3
                return false;
            }
        }

    }

    /**
     *
     *   修改策略找最短路径
     * 使用递归回调来给小球找路
     * 1.i.j 表示从地图那个位置出发
     * 2.如果找到6，5的位置说明通路找到
     * 3. 约定： 当map[i][j] 为0 表示该点没有走过 为1 是墙  2 表示可以走  3 表示该路径已经走过，但是不通
     * 4.在走迷宫时 我们需要确定一个策略（方法）  上-> 右 -> 下 ->左  如果该点走不通在回溯
     *
     * @param map 地图
     * @param i   从哪个位置开始找
     * @param j
     * @return
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        //通路已经找到OK
        if (map[6][5] == 2) {
            return true;
        } else {
            //如果 这个点还没有走过
            if (map[i][j] == 0) {
                //按照策略走  上-> 右 -> 下 ->左
                //  假定该点可以走通
                map[i][j] = 2;
                //向上走
                if (setWay(map, i - 1, j)) {
                    return true;
                    // 向右走
                } else if (setWay2(map, i, j + 1)) {
                    return true;
                    // 向下走
                } else if (setWay2(map, i+1, j)) {
                    return true;
                    //向左走
                } else if (setWay2(map, i, j-1)) {
                    return true;
                }else{
                    // 说明该点不通是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {
                // 如果 map[i][j] != 0  可能时1，2,3
                return false;
            }
        }

    }

}

