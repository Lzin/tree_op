package tree_op.heap_sort;

import java.util.Arrays;
/**
 * 800万个数据 大概3s左右排完 O(nlogn)
 * */
public class HeapSort {
    public static void main(String[] args) {
        //操作数组，将数组进行升序排序
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    //编写一个堆排序的方法
    public static void heapSort(int[] arr) {
        int temp=0;
        System.out.println("堆排序");
//        adjustHeap(arr,1,arr.length);
//        //第一次处理子树
//        System.out.println("第一次调整过后:"+ Arrays.toString(arr));// 4 9 8 5 6 ??
//        //在原来的基础上进行调整
//        adjustHeap(arr,0,arr.length);
//        //第二次处理子树
//        System.out.println("第二次调整过后:"+ Arrays.toString(arr));// 9,6,8,5,4

        //第1棵子树调整过后可得
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        System.out.println("调整过后:"+Arrays.toString(arr));
        /**
         * 将堆底的元素和堆顶元素进行交换
         * */
        for(int j=arr.length-1;j>0;j--){
            //交换
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            //将一棵树调整为大顶堆
            adjustHeap(arr,0,j);
        }
        System.out.println("调整过后:"+Arrays.toString(arr));
    }

    /**
     * 功能: 完成将以i为非叶子节点的子树调整为大顶堆
     * 4 6 8 5 9 => i=1 => adjustHeap => 4 9 8 5 6
     * 如果再次调用   i=0 => adjustHeap => 9 6 8 5 4
     *
     * <p>
     * arr: 待调整的数组实例(从左到右 从下到上进行调整)
     * i: 表示非叶子节点的索引
     * length: 对多少个元素进行调整，length在逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素的值，保存在临时变量中
        int temp = arr[i];
        //开始调整
        //1.k=i*2+1 说明k是i节点的左子节点;k=k*2+1 说明了k的下一轮是k节点的当前子节点

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //说明当前左子节点小于右子节点的值
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;//k指向右子节点
            }
            if(arr[k]>temp){//如果子节点大于父节点
                arr[i]=arr[k];//把较大的值赋给当前节点
                i=k;//!! 让i指向k(找到下一组子树进行比较)
            }else{
                break;//! 从小到大 从下到上进行调整
            }
        }
        //循环结束后，将以i为子树的最大值已经放在了最顶部，此时的i不再是原来的i了
        arr[i]=temp;//将temp放置到调整后的位置
    }
}
