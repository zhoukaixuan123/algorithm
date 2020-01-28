package linkedList;

import java.util.Stack;

/**
 * @author zhoukx
 * @date 2019/11/26
 * @description 双向链表
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode2 heroNode = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode1 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode2 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode3 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList2 doubleLinkedList2 = new DoubleLinkedList2();
        doubleLinkedList2.add(heroNode);
        doubleLinkedList2.add(heroNode1);
        doubleLinkedList2.add(heroNode2);
        doubleLinkedList2.add(heroNode3);
        System.out.println("========================显示双向链表=================");
        doubleLinkedList2.list();
        System.out.println("============修改==============");
        HeroNode2 heroNode4 = new HeroNode2(4, "公孙策", "龙灵");
        doubleLinkedList2.update(heroNode4);
        doubleLinkedList2.list();

        System.out.println("============删除==============");

        doubleLinkedList2.del(3);
        doubleLinkedList2.list();
    }
}

/**
 *
 *  创建双向链表的类
 */

/**
 * 定义一个SingleLinedList  管理我们的英雄
 */
class DoubleLinkedList2 {
    //先初始化一个头节点，头节点不要动  存的是头节点不提供具体的数据
    private HeroNode2 head = new HeroNode2(1, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 遍历双向链表的方法
     */

    public void list() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
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
     *   添加双向链表
     * @param heroNode
     */
    public void add(HeroNode2 heroNode) {

        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
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
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }


    /**
     *    修改双向链表   节点头
     *    可以看到修改双向链表的节点内容修改
     *    和单向列表一样
     * @param newHeroNode
     */
    public void update(HeroNode2 newHeroNode){

        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空。");
            return;
        }
        //找到需要修改的节点，根据no的编号
        HeroNode2 temp = head.next;
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
     *    删除双向链表中的一个系欸但
     *     说明
     *     1 对于双向链表，我们可以直接找到要删除的这个节点
     *     2  找到后，自我删除即可
     * @param no
     */
    public void del(int no){

        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
           return;
        }
        HeroNode2 temp = head.next;
        //标志是否找到待删除的节点
        boolean flag = false;
        while (true){
            //表示已经到链表的最后
            if(temp == null){
                break;
            }
            if (temp.no == no){
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
            temp.pre.next = temp.next;
            //如果是最后一个节点，就不需要执行下面这句话，
            //否则会出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("没有要删除的节点。。。");
        }

    }

}

/**
 * 定义一个HeroNode，每个HeroNode对象就是一个节点
 */
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    /**
     * 指向下一个节点  默认为null
     */
    public HeroNode2 next;
    /**
     * 执行前一个节点 默认为null
     */
    public HeroNode2 pre;

    //构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    /**
     * 为了显示方法，我们重新toString
     */
    @Override
    public String toString() {
        return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}

