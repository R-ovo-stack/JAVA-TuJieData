package Btree;
import java.io.*;

/**
 * 使用一维数组按照二叉搜索树的结点规则建立一个满二叉树
 */
public class ArrayBtree {
    public static void main(String[] args) {
        int i,level;  //level为1时为树根
        int data[]={6,3,5,9,7,8,4,2}; //原始数组
        int[] btree=new int[16];
        for(i=0;i<16;i++){
            btree[i]=0;
        }
        System.out.println("原始数组: ");
        for(i=0;i<8;i++){
            System.out.print("["+data[i]+"] ");
        }
        System.out.println();
        for(i=0;i<8;i++){  //将原始数组中的值逐一对比
            for(level=1;btree[level]!=0;){
                if(data[i]>btree[level])
                    level=2*level+1;
                else    level=2*level;
            }
            btree[level]=data[i];  //将数组数值放入二叉树
        }
        System.out.print("二叉树的内容: \n");
        for(i=0;i<16;i++){
            System.out.print("["+btree[i]+"]");
        }
        System.out.println();
    }

    
}
