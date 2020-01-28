package linkedList;

/**
 * @author zhoukx
 * @date 2019/11/26
 * @description 单向环形链表  约瑟夫思想验证
 */
public class Josepfu {


    public static void main(String[] args) {
        //测试链表是否成功
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        // 测试小孩出圈是否正确
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

/**
 * 创建单向循环链表
 */
class CircleSingleLinkedList{
    /**
     * 创建一个first节点，当前没有编号
     */
    private Boy first = new Boy(-1);
    //添加小孩节点，构建一个环形链表
    public void addBoy(int nums){
       //nums 做一个数据校验
        if (nums<1){
            System.out.println("nums的值不正确");
           return;
        }

        //辅助指针，帮助构建环形链表
        Boy curBoy = null;

        //使用for来创建我们的环形链表
        for (int i = 1; i <= nums ; i++) {
          //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i== 1) {
                first = boy;
                //构成环
                first.setNext(first);
                //让curBoy指向第一个小孩
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历当前环形链表
     */
    public  void  showBoy(){
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空---");
            return;
        }
        //因为first不能动，因此我们仍然是同一个辅助
        //指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            //说明遍历完毕
            if (curBoy.getNext() == first) {
                break;
            }
            //curBoy 后移
            curBoy = curBoy.getNext();
        }
    }



    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     * @param startNo  表示第几个小孩开始数数
     * @param countNum  表示数几下
     * @param nums  表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
          // 先对数据进行校验
        if (first == null || startNo < 1||startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建辅助指针，标注小孩完成出圈
         Boy helper = first;
        //  需求创建一个辅助指针helper，实现应该指向环形链表的最后这个节点
        while (true) {
            //说明helper 指向最后小孩节点
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        // 小孩报数前，先让first和helper 移动k-1次
        for (int i = 0; i <startNo-1 ; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当小孩报数是，让first和helper 指针同时移动m-1次，然后出圈
        while (true) {
            //说明圈中只有一个节点
            if(helper == first){
                break;
            }
            // 让first和helper 指针同时的移动countNUm -1
            for (int i = 0; i <countNum-1 ; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这时 first指向的节点，就是要出圈的小孩的节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            //这时佳能first指向小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }

        System.out.printf("最后留在圈中的小孩编号%d\n",helper.getNo());
    }
}

/**
 * 创建一个Boy类，表示一个节点
 */
class  Boy{
    /**
     * 编号
     */
    private  int no ;
    /**
     * 指向下一个节点，默认时null
     */
    private  Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
