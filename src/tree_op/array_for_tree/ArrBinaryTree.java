package tree_op.array_for_tree;
public class ArrBinaryTree {
    private int[] arr;//存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //编写方法完成顺序存储二叉树的前序遍历
    //index 数组的下标
    public void preOrder(int index){
        if(arr==null || arr.length==0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //开始前序遍历
        //输出该元素

        System.out.print(arr[index]+" ");

        //向左递归
        if((index*2+1)<arr.length){
            preOrder(2*index+1);
        }
        //向右递归
        if((index*2+2)<arr.length){
            preOrder(2*index+2);
        }
        //中序 左根右 后序 左右根
    }

    //方法的重载 如果采用无参方法，自动调用有参
    public void preOrder(){
        this.preOrder(0);
    }
}