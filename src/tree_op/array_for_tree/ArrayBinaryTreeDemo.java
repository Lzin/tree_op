package tree_op.array_for_tree;

/**
 * 完成顺序二叉树的遍历
 * 数组可以完成类似二叉树一样的遍历
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree tree=new ArrBinaryTree(arr);
        tree.preOrder();
    }
}



