package com.algorithm;

import java.util.*;
public class LC0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> curQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        curQueue.offer(root);
        while(!curQueue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            TreeNode curNode = curQueue.peek();
            while(curNode != null) {
                layer.add(curNode.val);
                if (curNode.left != null) {
                    nextQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nextQueue.offer(curNode.right);
                }
                curQueue.poll();
                curNode = curQueue.peek();
            }
            result.add(layer);
            Queue<TreeNode> tmp = curQueue;
            curQueue = nextQueue;
            nextQueue = tmp;
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> curLayer = new LinkedList<>();
        Queue<TreeNode> nextLayer = new LinkedList<>();
        curLayer.offer(root);
        while (!curLayer.isEmpty()) {
            List<Integer> curLayerResult = new ArrayList<>();
            while (!curLayer.isEmpty()) {
                TreeNode curNode = curLayer.peek();
                curLayerResult.add(curNode.val);
                if (curNode.left != null) {
                    nextLayer.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nextLayer.offer(curNode.right);
                }
                curLayer.remove();
            }
            result.add(curLayerResult);
            Queue<TreeNode> tmp = curLayer;
            curLayer = nextLayer;
            nextLayer = tmp;
        }
        return result;
    }
}
