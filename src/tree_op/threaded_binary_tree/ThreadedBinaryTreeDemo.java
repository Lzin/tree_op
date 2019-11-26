package tree_op.threaded_binary_tree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedHeroNode root = new ThreadedHeroNode(1, "1");
        ThreadedHeroNode node3 = new ThreadedHeroNode(3, "3");
        ThreadedHeroNode node6 = new ThreadedHeroNode(6, "6");
        ThreadedHeroNode node8 = new ThreadedHeroNode(8, "8");
        ThreadedHeroNode node10 = new ThreadedHeroNode(10, "10");
        ThreadedHeroNode node14 = new ThreadedHeroNode(14, "14");
        root.setLeft(node3);
        root.setRight(node6);
        node3.setLeft(node8);
        node3.setRight(node10);
        node6.setRight(node14);
        ThreadedBinaryTree tree=new ThreadedBinaryTree();
        tree.setRoot(root);
        //开始进行转换
        tree.threadedNodes();
        System.out.println(node10.getRight());
        System.out.println(node8.getRight());
        System.out.println(node8.getLeft());

        System.out.println("使用线索化的方式遍历 线索化二叉树");
        tree.threadedMidList();
        //线索化二叉树之后不能使用原始的递归方法

    }
}

