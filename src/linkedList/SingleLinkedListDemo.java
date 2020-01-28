package linkedList;

import java.util.Stack;

/**
 * @author zhoukx
 * @date 2019/11/24
 * @description 单向链表
 * <p>
 * 需求：
 * 使用带head头的单向链表实现 –水浒英雄排行榜管理
 * 完成对英雄人物的增删改查操作， 注: 删除和修改,查找可以考虑学员独立完成，也可带学员完成
 * 第一种方法在添加英雄时，直接添加到链表的尾部
 * 第二种方式在添加英雄时，根据排名将英雄插入到指定位置(如果有这个排名，则添加失败，并给出提示)
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode1 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode2 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(4, "林冲", "豹子头");

        //创建单链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //不加排序
//        singleLinkedList.add(heroNode);
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
        // 加排序
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode);
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode2);




        //显示循环打印
        System.out.println("======================修改前  显示=====================");
        singleLinkedList.list();


        //显示循环打印
        System.out.println("======================反转  显示=====================");
        SingleLinkedList.reversetList(singleLinkedList.getHead());
        singleLinkedList.list();
        //测试逆序打印

        System.out.println("======================逆序打印  显示=====================");
        SingleLinkedList.reversePrint(singleLinkedList.getHead());



        //测试按照编号修改
//
//        HeroNode newNorde = new HeroNode(4, "林冲1", "老虎头");
//        singleLinkedList.update(newNorde);
//
//        //显示循环打印
//        System.out.println("======================修改后 显示=====================");
//        singleLinkedList.list();
//
//        //删除节点
//        singleLinkedList.del(4);
//
//        //显示循环打印
//        System.out.println("======================删除 显示=====================");
//        singleLinkedList.list();
//
//        System.out.printf("有效的节点个数有"+SingleLinkedList.getLength(singleLinkedList.getHead()));
//
//        //测试是都得到了第倒数K个节点
//        HeroNode heroNode4 = SingleLinkedList.finLastIndexNode(singleLinkedList.getHead(), 2);
//        System.out.println(heroNode4);

    }

}

/**
 * 定义一个SingleLinedList  管理我们的英雄
 */
class SingleLinkedList {
    //先初始化一个头节点，头节点不要动  存的是头节点不提供具体的数据
    private HeroNode head = new HeroNode(1, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单向链表
     * 思路，当不考虑编号顺序时
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的next 指向 新的节点
     */
    public void add(HeroNode heroNode) {

        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，知道最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当推出循环时，temp就指向了链表最后
        //将对吼这个节点的next 指向新的节点
        temp.next = heroNode;
    }

    /**
     * 第二种方式在添加英雄时，根据排名将英雄插入到指定位置  (如果有这个排名，则添加失败，并给出提示)
     */
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍仍然通过一个辅助指针来帮助我们找到添加的位置
        //因为时单链表，因此我们找的temp是位于添加位置的前一个节点，
        // 否则添加不了
        HeroNode temp = head;
        //标志添加的编号是否存在，默认是否存在
        boolean flag = false;
        while (true) {
            //说明temp已经是在链表的最后
            if (temp.next == null) {
                break;
            }
            //位置找到，就在temp的后面插入
            if (temp.next.no > heroNode.no) {
                    break;
                    //说明希望日俺家的hreoNode的编号已经存在
            }else if(temp.next.no ==  heroNode.no){
                     flag = true;
                     break;
            }
            //后移 遍历当前链表
            temp = temp.next;
        }
        //判断flag 的值,true  不能添加，说明编号存在
        if(flag){
            System.out.printf("准备插入的英雄编号%d已经存在，不能加入\n",heroNode.no);
        }else {
            //插入链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    /**
     * 显示链表【遍历】
     */
    public void list() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否时链表的最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 修改节点信息，根据no编号来修改，即no编号不能改
     *
     *  说明
     *  1 根据newHeroNode的no来修改即可
     */
    public void update(HeroNode newHeroNode){

        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空。");
            return;
        }
        //找到需要修改的节点，根据no的编号
        HeroNode temp = head.next;
        //表示是否找到这个节点
        boolean flag = false;
        while (true){
            if (temp == null){
                //表示已经遍历完链表
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
       //根据flag判断是都找到修改的节点
        if(flag){
           temp.name = newHeroNode.name;
           temp.nickname = newHeroNode.nickname;
        }else {
            //没有找到
            System.out.printf("没有找到修改的节点",newHeroNode.no);
        }

    }


    /**
     *   删除节点
     *
     *   思路
     *     1 head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     *     2 说明我们在比较时，是temp.next.no和需要删除的节点no的比较
     *
     */

    public void del(int no){
        HeroNode temp = head;
        //标志是否找到待删除的节点
        boolean flag = false;
        while (true){
            //表示已经到链表的最后
            if(temp.next == null){
              break;
            }
            if (temp.next.no == no){
                //找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            //temp 后移 遍历
            temp = temp.next;
        }
        //判断flag
        if (flag) {
            //找到节点，进行删除
            temp.next = temp.next.next;
        }else {
            System.out.println("没有要删除的节点。。。");
        }

    }

    /**
     *
     *    面试题
     *       获取点链表的节点个数（如果是带头的链表，需要不统计头节点）
     *
     *   head  头节点
     */

      public static  int getLength(HeroNode head){
          if(head.next == null){
              return 0;
          }
          int length = 0;
          //定义一个辅助变量
          HeroNode cur = head;
          while(cur.next != null){
              length ++ ;
              //遍历
              cur = cur.next;
          }
          return  length;
      }


    /**
     *
     * 查找单链表中的倒数第k个结点 【新浪面试题】
     *
     *   思路
     *      1.编写一个方法，接受head节点，同时接受一个index
     *      2.index 表示倒数第index个节点
     *      3.先把链表从头到尾遍历，得到链表总长度
     *      4. 得到size后，我们从链表的第一个开始遍历（size-index）个
     *      就可以得到了
     *      5.如果找到了返回该节点，否则返回null
     *
     */

     public static HeroNode finLastIndexNode(HeroNode head,int index){
         //判断链表为空，返回null
         if (head.next == null) {
             //没有找到节点
             return null;
         }
         //第一个遍历得到链表的长度（节点个数）
         int size = getLength(head);
         //第二次遍历size -index 位置，就是我们倒数的第K个节点
         //先做一个index的校验
         if(index <= 0 || index > size ){
            return  null;
         }
         //定义辅助变量,for循环定位到倒数的index
         HeroNode cur = head.next;
         for (int i = 0; i <size-index ; i++) {
             cur = cur.next;
         }
         return  cur;
     }


    /**
     * 单链表的反转【腾讯面试题，有点难度】
     *
     *
     *
     */

    public static  void reversetList(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
          return;
        }
       //定义辅助的指针变量，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        //指向当前节点 cur的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表
        //每遍历一个节点就将其取出，并放在新的链表reverseHead的最前端
        while (cur != null){
            //先暂存当前节点的下一个节点，因为后面需要使用
            next = cur.next;
            //将cur的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            //让原列表数据  加到新的而链表上
            reverseHead.next = cur;
            //让cur后移
            cur = next;
        }
        //将head.next 子项reverseHead。next  实现单链表反转
        head.next = reverseHead.next;

    }

    /**
     *
     * 从尾到头打印单链表 【百度，要求方式1：反向遍历 。 方式2：Stack栈】
     *
     *   使用方式二  栈的特性从头到尾打印数据
     */
    public static  void reversePrint(HeroNode head){
        if (head.next == null) {
           //空列表  不能打印
            return;
        }
        //创建一个栈，将节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            //将cur后移，这样就可以压入下一个节点
            cur = cur.next;
        }
        //将栈中的节点进行打印，pop 出栈
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

}

/**
 * 定义一个HeroNode，每个HeroNode对象就是一个节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    //指向下一个节点
    public HeroNode next;

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    /**
     * 为了显示方法，我们重新toString
     */
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}
