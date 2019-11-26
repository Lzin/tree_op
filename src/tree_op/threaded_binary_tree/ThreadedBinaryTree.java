package tree_op.threaded_binary_tree;

public class ThreadedBinaryTree {
    private ThreadedHeroNode root;

    //为了实现线索化，需要创建执行当前节点的前驱节点的引用
    //将二叉树转换为一个特殊的双向链表
    private ThreadedHeroNode pre = null;//在递归进行线索化时，pre总是保留前一个节点

    public void setRoot(ThreadedHeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前二叉树为空，无法前序遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("当前二叉树为空，无法中序遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("当前二叉树为空，无法后序遍历");
        }
    }

    //前序查找
    public ThreadedHeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            System.out.println("当前二叉树为空,无法前序查找");
            return null;
        }
    }

    //中序查找
    public ThreadedHeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return this.root.infixOrderSearch(no);
        } else {
            System.out.println("当前二叉树为空，无法中序查找");
            return null;
        }
    }

    //后序查找
    public ThreadedHeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            System.out.println("当前二叉树为空，无法后序查找");
            return null;
        }
    }

    //删除节点
    public void delNode(int no) {
        if (root != null) {
            //如果根节点匹配，删除根节点
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树不能删除~~");
        }
    }

    //对二叉树进行中序线索化的代码
    /**
     * node 当前线索化的节点
     */
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    public void threadedNodes(ThreadedHeroNode node) {
        //如果node==null 无法进行线索化直接退出
        if (node == null) {
            return;
        }
        //按照中序线索化的方式处理
        //1.先递归线索化左节点
        threadedNodes(node.getLeft());
        //2.再线索化当前节点[！！！]
        //先处理当前节点的前驱节点
        //pre在何时赋值？？
        if (node.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型,指向前驱节点
            node.setLeftType(1);
        }
        //假设在一轮后执行到此处，当时pre==null，所以直接把pre=node
        //第二次进行递归的时候，然后就可以处理后置节点了
        //在处理后置节点的时候 pre已经是位于该节点了
        //处理后继节点 后继的设置在当前节点为pre时设置!!!
        if (pre != null && pre.getRight() == null) {
            //前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        //每处理一个节点 让当前节点是下一个节点的前驱节点
        pre = node;
        //3.再线索化右子树
        threadedNodes(node.getRight());
    }

    /**
     * 遍历线索化二叉树
     *
     * */
    public void threadedMidList(){
        //定义一个变量存储当前遍历的节点
        //从root开始
        ThreadedHeroNode node=root;
        while(node!=null){
            //循环找到leftType=1的节点,后面随着遍历而变化
            //当left=1 说明了该节点就是按照线索化的有效节点
            while(node.getLeftType()==0){
                node=node.getLeft();
            }
            //找到了leftType为1的 本栗中也就是8
            System.out.println(node);
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while(node.getRightType()==1){
                //获取到当前节点的后继节点
                node=node.getRight();
                System.out.println(node);
            }
            //替换遍历的节点
            //当node.getLeftType()==0的时候 指向真实的值，从而进行下一次的判定
            node=node.getRight();
        }
    }

}
