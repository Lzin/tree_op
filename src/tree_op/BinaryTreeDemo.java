package tree_op;
//树的遍历
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先需要创建一棵二叉树
        BinaryTree myTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "p1");
        HeroNode node2 = new HeroNode(2, "p2");
        HeroNode node3 = new HeroNode(3, "p3");
        HeroNode node4 = new HeroNode(4, "p4");
        HeroNode node5 = new HeroNode(5, "p5");
        HeroNode preSearchNode = null;
        HeroNode infixSearchNode = null;
        HeroNode postSearchNode = null;
        //1.先手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        //2.将节点给root
        myTree.setRoot(root);

        //测试一下前序遍历 根左右 12354
        System.out.println("前序遍历:");
        myTree.preOrder();
        System.out.println("========================");
        //测试一下中序遍历 左根右 21534
        System.out.println("中序遍历:");
        myTree.infixOrder();
        System.out.println("========================");
        //测试一下后序遍历 左右根 25431
        System.out.println("后序遍历:");
        myTree.postOrder();

        System.out.println("========================");
        //开始测试查询方法
        System.out.println("前序查找");
        preSearchNode = myTree.preOrderSearch(5);
        if (preSearchNode != null) {
            System.out.println("查询到该节点的编号为" + preSearchNode.getNo() + " " + "该节点的名称为" + preSearchNode.getName());
        } else {
            System.out.println("未找到该结点");
        }

        System.out.println("========================");
        //开始测试查询方法
        System.out.println("中序查找");
        infixSearchNode = myTree.infixOrderSearch(4);
        if (infixSearchNode != null) {
            System.out.println("查询到该节点的编号为" + infixSearchNode.getNo() + " " + "该节点的名称为" + infixSearchNode.getName());
        } else {
            System.out.println("未找到该结点");
        }

        System.out.println("========================");
        //开始测试查询方法
        System.out.println("后序查找");
        postSearchNode = myTree.postOrderSearch(10);
        if (postSearchNode != null) {
            System.out.println("查询到该节点的编号为" + postSearchNode.getNo() + " " + "该节点的名称为" + postSearchNode.getName());
        } else {
            System.out.println("未找到该结点");
        }
        //开始测试删除方法
        System.out.println("=========================");
        System.out.println("删除节点");
        myTree.delNode(5);
        //前序遍历证明删除结果
        myTree.preOrder();
    }
}
