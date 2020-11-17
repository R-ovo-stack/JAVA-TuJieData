package Btree;

/**
 * 二叉树转换为线索二叉树：【中序建立】
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
class Thread_BInary_Tree{
    public ThreadNode rootNode;  //线索二叉树根节点

    public Thread_BInary_Tree(){
        rootNode=null;
    }
    public Thread_BInary_Tree(int[] data){
        for(int i=0;i<data.length;i++){
            AddNode(data[i]);
        }
    }

    void AddNode(int value){
        ThreadNode Newnode=new ThreadNode(value);
        ThreadNode current;
        ThreadNode parent;
        ThreadNode previous=new ThreadNode(value);
        int pos;
        //设置线索二叉树的开头结点
        if(rootNode==null){
            rootNode=Newnode;
            rootNode.left=rootNode;
            rootNode.right=null;
            rootNode.left_Thread=0;
            rootNode.right_Thread=1;
            return;
        }
        //设置开头结点所指的结点
        current=rootNode.right;
        if(current==null){
            rootNode.right=Newnode;
            Newnode.left=rootNode;
            Newnode.right=rootNode;
            return;
        }
        parent=rootNode;  //父节点是开头结点
        pos=0;  //设置二叉树中的行进方向
        while(current!=null){
            if(current.value>value){
                if(pos!=-1){
                    pos=-1;
                    previous=parent;
                }
                parent=current;
                if(current.left_Thread==1)
                    current=current.left;
                else    current=null;
            }
            else{
                if(pos!=1){
                    pos=1;
                    previous=parent;
                }
                parent=current;
                if(current.right_Thread==1)
                    current=current.right;
                else    current=null;
            }
        }
        if(parent.value>value){
            parent.left_Thread=1;
            parent.left=Newnode;
            Newnode.right=previous;
            Newnode.right=parent;
        }else{
            parent.right_Thread=1;
            parent.right=Newnode;
            Newnode.left=parent;
            Newnode.right=previous;
        }
        return;

    }

    //线索二叉树中序遍历
    void print(){
        ThreadNode tempNode;
        tempNode=rootNode;
        do{
            if(tempNode.right_Thread==0)
                tempNode=tempNode.right;
            else{
                tempNode=tempNode.right;
                while(tempNode.left_Thread!=0)
                    tempNode=tempNode.left;
            }
            if(tempNode!=rootNode)
                System.out.println("["+tempNode.value+"]");
        }while(tempNode!=rootNode);
    }
}

public class XianSuoTree{
    public static void main(String[] args) {
        System.out.println("线索二叉树经建立以后，以中序遍历有排序的效果");
        System.out.println("除了第一个数字作为线索二叉树的而开头结点意外");
        int[] data1={0,10,20,30,100,399,453,43,237,373,655};
        Thread_BInary_Tree tree1=new Thread_BInary_Tree(data1);
        System.out.println("==============");
        System.out.println("范例1");
        System.out.println("数字从小到大的排序结果为:");
        tree1.print();
        int[] data2={0,101,118,87,12,765,65};
        Thread_BInary_Tree tree2=new Thread_BInary_Tree(data2);
        System.out.println("==============");
        System.out.println("范例2");
        System.out.println("数字从小到大的排序结果为:");
        tree2.print();
    }
}