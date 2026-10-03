/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
   
    public String serialize(TreeNode root) {
        StringBuilder st = new StringBuilder();
        serhelper(root,st);
        return st.toString();
    }

    static void  serhelper(TreeNode root, StringBuilder st){
        if(root == null){
            st.append("null ");
            return;
        }
        st.append(root.val).append(" ");
        serhelper(root.left,st);
        serhelper(root.right,st);
    }

    // Decodes your encoded data to tree.
    
    public TreeNode deserialize(String data) {
        String[] s = data.split(" ");
        int[] i = {0};
        return deshelp(s,i);
    }

    static TreeNode deshelp(String[] data,int[] i){
        if(data[i[0]].equals("null")){
            i[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[i[0]]));
        i[0]++;
        root.left = deshelp(data,i);
        root.right = deshelp(data,i);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));