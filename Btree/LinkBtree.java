package Btree;

/**
 * 二叉排序树 || 二叉搜索树
 */
import java.io.*;

//import sun.jvm.hotspot.opto.RootNode;

//import jdk.internal.jline.internal.InputStreamReader;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class LinkBtree {
    public TreeNode rootNode; // 二叉树根节点
    // 二叉树构造函数 || 直接传入一个数组进行二叉树的创建

    public LinkBtree(int[] data) {
        for(int i=0;i<data.length;i++){
            AddNodeToTree(data[i]);
        }
    }


    /**
     * 以二叉搜索树的插入规律递归创建二叉树
     * @param value
     */
    public void AddNodeToTree(int value) {
        TreeNode currentNode = rootNode; // 获取根结点
        if (rootNode == null) { // 如果二叉树树根为null,则建立树根
            rootNode = new TreeNode(value);
            return;
        }
        // 建立二叉树
        while (true) {
            if (value < currentNode.value) { // 在左子树 || 值比根结点小 || 二叉线索树
                if (currentNode.left == null) {
                    currentNode.left = new TreeNode(value); // 如果左孩子不存在
                    return;
                } else
                    currentNode = currentNode.left;
            } else { // 在右字树 || 大于或者等于
                if (currentNode.right == null) {
                    currentNode.right = new TreeNode(value); // 如果右孩子不存在
                    return;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    //前序遍历
    public void PreOrder(TreeNode node){
        if(node!=null){
            System.out.print("["+node.value+"]  ");
            PreOrder(node.left);
            PreOrder(node.right);
        }
    }

    public void InOrder(TreeNode node){
        if(node!=null){
            InOrder(node.left);
            System.out.print("["+node.value+"]  ");
            InOrder(node.right);
        }
    }

    public void ProOrder(TreeNode node){
        if(node!=null){
            ProOrder(node.left);
            ProOrder(node.right);
            System.out.print("["+node.value+"]  ");
        }
    }

    public static void main(String args[]) throws NumberFormatException, IOException {
        int size=10;
        int tempdata;
        int[] content=new int[size];

        //使用输入流输入数据 || 此处没有使用常用Scanner类
        BufferedReader data=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请连续输入" + size + "个数据");
        for(int i=0;i<size;i++){
            System.out.println("请输入第"+ (i+1)+ " 个数据:");
            tempdata=Integer.parseInt(data.readLine());
            content[i]=tempdata;
        }
        LinkBtree tone=new LinkBtree(content);
        System.out.println("链表方式建立二叉树成功...");
        tone.InOrder(tone.rootNode);
        System.out.println();
        tone.PreOrder(tone.rootNode);
        System.out.println();
        tone.ProOrder(tone.rootNode);
    }
}