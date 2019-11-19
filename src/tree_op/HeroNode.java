package tree_op;

import org.omg.CORBA.NO_IMPLEMENT;

//创建树的节点
public class HeroNode {
    private int no;
    ;
    private String name;
    private HeroNode left; //默认为null
    private HeroNode right;//默认为null

    //建立构造器
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

    @Override
    public String toString() {
        return "HeroNode[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ']';
    }

    //编写前序遍历的方法 根->左->右
    public void preOrder() {
        //输出父节点
        System.out.println(this);
        //递归向左
        if (this.left != null) {

            this.left.preOrder();
        }
        //递归向右子树遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //编写中序遍历的方法 左->根->右
    public void infixOrder() {
        //递归向左
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //编写后序遍历的方法 左->右->根
    public void postOrder() {
        //遍历向左
        if (this.left != null) {
            this.left.postOrder();
        }
        //遍历向右
        if (this.right != null) {
            this.right.postOrder();
        }
        //中
        System.out.println(this);
    }

    //编写前序查找方法
    //比较->左递归->右递归
    //如果找到了就返回该node，如果没有找到返回null
    public HeroNode preOrderSearch(int no) {
        HeroNode resNode = null;
        //比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        //判断当前节点的左节点是否为空，如果不为空则进行左递归

        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //如果resNode为空，则判断右子节点情况
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //编写中序查找算法
    //左递归->比较->右递归
    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        //开始进左递归查找
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //如果找到，则返回,如果没有找到，就和当前节点比较
        if (this.no == no) {
            return this;
        }
        //否则进行继续向右进行中序查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    //左递归->右递归->中
    public HeroNode postOrderSearch(int no){
        //左递归
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.postOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        //右递归
        if(this.right!=null){
            resNode=this.right.postOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        //中
        if(this.no==no){
            return this;
        }
        return resNode;
    }


}
