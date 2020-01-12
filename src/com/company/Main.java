package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        int firstSmall = Integer.MAX_VALUE, secondSmall = Integer.MAX_VALUE;
        boolean found = false;
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            TreeNode curr = list.poll();
            if (curr.val < firstSmall) {
                secondSmall = firstSmall;
                firstSmall = curr.val;
            } else if (curr.val != firstSmall && curr.val <= secondSmall){
                secondSmall = curr.val;
                found = true;
            }
            if (curr.left != null) {
                list.offer(curr.left);
            }
            if (curr.right != null) {
                list.offer(curr.right);
            }
        }
        return !found ? -1 : secondSmall;
    }
}

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }

        int left = root.left.val;
        int right = root.right.val;

        // if value same as root value, need to find the next candidate
        if (root.left.val == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }
}