package com.algorithm;
import java.util.*;
public class LC0144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode!= null || !stack.isEmpty()) {
            while (curNode != null) {
                result.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (!stack.isEmpty()) {
                curNode = stack.pop();
                curNode = curNode.right;
            }
        }
        return result;
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal2(root.left));
        result.addAll(preorderTraversal2(root.right));
        return result;
    }

    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                result.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (!stack.isEmpty()) {
                curNode = stack.pop();
                curNode = curNode.right;
            }
        }
        return result;
    }
}
