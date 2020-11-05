package Btree;

/**
 * 二叉树转换为线索二叉树：
 * 先将二叉树通过中序遍历方式按序输出，并将所有空链接改成线索
 * 如果线索链接指向该结点的左连接，则将该线索指到中序遍历顺序下前一个结点
 * 如果线索链接指向该结点的右链接，则将该线索指到中序遍历顺序下的后一个结点
 * 指向一个空结点，并将此空结点的右链接指向自己，而空结点的左子树是此线索二叉树
 * 
 * ^如果右孩子为正常指针，则right_Thread=1,否则为0[null]
 * ^如果左孩子为正常指针，则left_Thread=1，否则为0[null]
 */
class ThreadNode{
    int value;
    int left_Thread; //左线索
    int right_Thread; //右线索
    ThreadNode left;
    ThreadNode right;
    public ThreadNode(int value){
        this.value=value;
        this.left=null;
        this.right=null;
        this.left_Thread=0;
        this.right_Thread=0;
    }
}
