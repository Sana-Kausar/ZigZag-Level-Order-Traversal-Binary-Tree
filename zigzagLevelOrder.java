package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left=null;
        right=null;
     }
  }
public class zigzagLevelOrder {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        TreeNode A=new TreeNode(3);
        TreeNode B=new TreeNode(9);
        TreeNode C=new TreeNode(20);
        TreeNode D=new TreeNode(15);
        TreeNode E=new TreeNode(7);
        A.left=B;
        A.right=C;
        C.left=D;
        C.right=E;
        result=zigZag(A);
        System.out.println(result);
    }

    public static ArrayList<ArrayList<Integer>> zigZag(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        if(A==null){
            return ans;
        }
        Deque<TreeNode> q=new LinkedList<TreeNode>();
        q.add(A);
        TreeNode last=A;
        int level=1;
        ArrayList<Integer> tempList=new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            tempList.add(curr.val);
            if(curr.left!=null)q.add(curr.left);
            if(curr.right!=null)q.add(curr.right);
            if(last==curr){
                if(level%2==0){
                    Collections.reverse(tempList);
                    ans.add(tempList);
                }
                else{
                    ans.add(tempList);
                }
                tempList=new ArrayList<Integer>();
                if(!q.isEmpty()){
                    last=q.getLast();
                    level++;
                }
            }
        }
        return ans;
    }
}
