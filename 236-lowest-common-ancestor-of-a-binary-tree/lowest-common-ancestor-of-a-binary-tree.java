/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 import java.util.*;
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ans1 = new ArrayList<>();
        List<TreeNode> ans2 = new ArrayList<>();
        lowestCommonAncestor1(root,p,ans1);
        lowestCommonAncestor1(root,q,ans2);
        int i=0,j=0;
        while(i<ans1.size() && j<ans2.size()){
            if(ans1.get(i) == ans2.get(j)){
                i++;
                j++;
            }else{
                break;
            }
        }
        return ans1.get(i-1);
    }
    static boolean lowestCommonAncestor1(TreeNode root,TreeNode p,List<TreeNode> ans1){
        if(root == null) return false;
           ans1.add(root);
        if(root.val == p.val) return true;
     

        if(lowestCommonAncestor1(root.left , p, ans1) || lowestCommonAncestor1(root.right, p, ans1)) return true;
        ans1.remove(ans1.size()-1);

        return false;
    }
    
}