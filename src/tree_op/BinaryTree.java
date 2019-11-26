package tree_op;

//定义一棵简单的二叉树
//HeroNode提供了遍历的方法，然后由BinaryTree去调用
public class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
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
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            System.out.println("当前二叉树为空,无法前序查找");
            return null;
        }
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return this.root.infixOrderSearch(no);
        } else {
            System.out.println("当前二叉树为空，无法中序查找");
            return null;
        }
    }

    //后序查找
    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            System.out.println("当前二叉树为空，无法后序查找");
            return null;
        }
    }

    //删除节点
    public void delNode(int no){
        if(root!=null){
            //如果根节点匹配，删除根节点
            if(root.getNo()==no){
                root=null;
            }else{
                root.delNode(no);
            }
        }else {
            System.out.println("空树不能删除~~");
        }
    }

}
