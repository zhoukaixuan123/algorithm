package tree;

/**
 * @author zhoukx
 * @date 2020/1/20
 * @description 二叉树遍历
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BianryTree bianryTree = new BianryTree();
        // 需要的节点
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"吴勇");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"林冲");
        HeroNode node5 = new HeroNode(5,"周凯旋");
        //  手动创建二叉树，后面使用递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        bianryTree.setRoot(root);

//        // 前序遍历
//        bianryTree.preOrder();
//
//        System.out.println("中序遍历");
//        bianryTree.infixOrder();
//        System.out.println("后序遍历");
//        bianryTree.postOrder();
//
//
//        System.out.println("前序查询");
//        HeroNode node = root.preOrderSearch(15);
//        if (node != null) {
//            System.out.printf("找到了信息为 no=%d   name=%s",node.getNo(),node.getName());
//        }else {
//            System.out.printf("没有找到");
//        }
        System.out.println("删除前，前序遍历");
        bianryTree.preOrder();
        bianryTree.delNode(5);
        System.out.println("删除后，前序遍历");
        bianryTree.preOrder();
    }

}
// 创建 二叉树
class BianryTree{
  private HeroNode root;

    public BianryTree() {
    }

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public BianryTree(HeroNode root) {
        this.root = root;
    }
    // 前序遍历
    public void preOrder(){
        if (this.root != null){
             this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 中序遍历
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 后序遍历
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 前序查询
    public HeroNode preOrderSearch(int no){
        if(root != null){
            return  root.preOrderSearch(no);
        }else {
            return  null;
        }
    }

    // 中序查询
    public HeroNode infixOrderSearch(int no){
        if(root != null){
            return  root.infixOrderSearch(no);
        }else {
            return  null;
        }
    }

    // 后序序查询
    public HeroNode postOrderSearch(int no){
        if(root != null){
            return  root.postOrderSearch(no);
        }else {
            return  null;
        }
    }
    // 删除节点
    public void delNode(int no){
        if (root != null){
            // 先判断root节点 是不是需要删除的节点
            if(root.getNo() == no){
                root = null;
            }else{
                root.delNode(no);
            }
        }else {
            System.out.println("空树不能删除");
        }
    }
}

// 创建节点
class HeroNode{
    private  int no;
    private String name;
    private  HeroNode left;
    private  HeroNode right;


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    // 前序遍历
    public void preOrder(){
        // 先输出父节点
        System.out.println(this);
        // 递归想左子树前序遍历
        if (this.left != null){
            this.left.preOrder();
        }
        // 向右子树 前序遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }
    // 中序遍历
    public void infixOrder(){
        // 递归向左子树中序遍历
        if (this.left != null){
            this.left.infixOrder();
        }
        // 输出父节点
        System.out.println(this);
        // 递归向右子树中序遍历
        if (this.right != null){
            this.right.infixOrder();
        }
    }
    // 后序遍历
    public void postOrder(){
        // 递归向左子树后序遍历
        if (this.left != null){
            this.left.postOrder();
        }
        // 递归向右子树后序遍历
        if (this.right != null){
            this.right.infixOrder();
        }
        // 输出父节点
        System.out.println(this);
    }



    /**
     * 前序遍历查找
     * @param no  查找no
     * @return
     */
    public HeroNode preOrderSearch(int  no){
        // 当前节点是不是
        if(this.no== no){
            return  this;
        }
        //1. 判断当前节点的做节点是否为空，如果不是空，则左递归查找
        //2  如果左递归查找，找到节点就返回
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode!= null ){
            return  resNode;
        }
       // 1 z左递归前序查找 找到节点则返回，否则继续判断
        // 当前的节点右字节点是否为空，如果不为空，则继续向右递归前序查找
        if(this.right != null){
            resNode = this.right.preOrderSearch(no);
        }

        return  resNode;
    }

    /**
     *    中序遍历查找
     * @return
     */
      public HeroNode infixOrderSearch(int no){
         // 判断当前节点的做节点是否为空，如果不为空，则递归中序查找
          HeroNode resNode = null;
          if(this.left != null){
              resNode = this.left.infixOrderSearch(no);
          }
          if(resNode!= null ){
              return  resNode;
          }
          // 当前节点是不是
          if(this.no== no){
              return  this;
          }
          // 向右递归中序查找
          if(this.right != null){
              resNode = this.right.infixOrderSearch(no);
          }

          return  resNode;
      }


    /**
     *    后序遍历查找
     * @return
     */
    public HeroNode postOrderSearch(int no){
        // 判断当前节点的做节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        // 说明左边找到了
        if(resNode!= null ){
            return  resNode;
        }
        // 向右递归中序查找
        if(this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        // 说明右边找到了
        if(resNode!= null ){
            return  resNode;
        }
       // 当前节点是不是
        if(this.no== no){
            return  this;
        }
        return  resNode;
    }

    /**
     * 递归删除节点
     * @param no
     * 如果删除的节点是叶子节点，则删除该节点
     * 如果删除的节点是非叶子节点，则删除该子树
     */
    public  void  delNode(int no){

        //思路分析
        // 1.因为我们的二叉树是单向的，所以我们是判断当前节点的子节点是否需要删除节点，而不是去判断当前这个节点是不是需要删除节点
        // 2.如果当前节点的左子节点不为空，并且左子节点，就是要删除节点，就将this.left = null,并且返回（结束递归删除）
        //3. 如果当前节点的右子节点不为空，并且右子节点就要删除节点，就将this.right = null,并且就返回（结束递归删除）
        // 4 如果第2和第3步没有删除节点，那么我们就需要向左子树进行递归删除
        // 5 如果第4步也没有删除节点，则应当向右子树进行递归删除

        // 2.如果当前节点的左子节点不为空，并且左子节点，就是要删除节点，就将this.left = null,并且返回（结束递归删除）
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        //3. 如果当前节点的右子节点不为空，并且右子节点就要删除节点，就将this.right = null,并且就返回（结束递归删除）
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
      // 左递归删除
      if(this.left != null){
           this.left.delNode(no);
       }
        // 右递归删除
        if(this.right != null){
            this.right.delNode(no);
        }
    }

}
