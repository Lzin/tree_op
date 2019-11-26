package tree_op.threaded_binary_tree;

//线索化二叉树的节点
public class ThreadedHeroNode {
    private int no;
    private String name;
    private ThreadedHeroNode left; //默认为null
    private ThreadedHeroNode right;//默认为null
    //说明
    //1.规定 如果leftType=0 表示指向的是左子树  如果为1表示指向的是前驱节点
    //2.规定 如果rightType=0表示指向的是右子树  如果为1表示指向的是后继节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    //建立构造器
    public ThreadedHeroNode(int no, String name) {
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

    public ThreadedHeroNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedHeroNode left) {
        this.left = left;
    }

    public ThreadedHeroNode getRight() {
        return right;
    }

    public void setRight(ThreadedHeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "ThreadedHeroNode[" +
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
    public ThreadedHeroNode preOrderSearch(int no) {
        ThreadedHeroNode resNode = null;
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
    public ThreadedHeroNode infixOrderSearch(int no) {
        ThreadedHeroNode resNode = null;
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
    public ThreadedHeroNode postOrderSearch(int no) {
        //左递归
        ThreadedHeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //右递归
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //中
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
    //删除节点的操作
    //1.如果删除的节点是叶子节点，则删除该节点
    //2.如果删除的节点是非叶子节点，则删除该子树

    /**
     * .如果当前节点的左子节点不为空，并且左子节点的编号就是需要删除的节点。就将this.left=null，并且返回即可(结束删除任务)
     * .如果当前节点的右子节点不为空，并且右子节点的编号就是需要删除的节点，就将this.right=null，并且返回即可(结束删除任务)
     * .如果第2 3没有完成，我们就要向左子树进行递归删除
     * .如果4没有完成，我们就要向右子树进行递归删除
     */
    public void delNode(int no) {
        //如果在左边找到了该节点 直接将该节点清零
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //如果在右边找到了该节点 直接将该节点清零
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //如果上述操作没有完成 开始递归
        if (this.left != null) {
            //但是最后会回到调用者的地方(类似弹栈)
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}