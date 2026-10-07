/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> twosum = new ArrayList<>();
        TWOSUM(root,twosum);
        int i=0, j=twosum.size()-1;
        while(i<j){
            int sum = twosum.get(i)+twosum.get(j);
            if(sum == k) return true;
            else if(sum<k) i++;
            else j--;
        }
        return false;
    }
    static void TWOSUM(TreeNode root,List<Integer> ans){
        if(root == null) return;
        TWOSUM(root.left,ans);
        ans.add(root.val);
        TWOSUM(root.right,ans);
    }
}