package com.algorithm;
import java.util.*;
class TreeNode {int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class LC0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while(curNode != null || !stack.isEmpty()) {
            while (curNode!= null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (!stack.isEmpty()) {
                curNode = stack.pop();
                result.add(curNode.val);
                curNode = curNode.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (!stack.isEmpty()) {
                curNode = stack.pop();
                result.add(curNode.val);
                curNode = curNode.right;
            }
        }
        return result;
    }
}
