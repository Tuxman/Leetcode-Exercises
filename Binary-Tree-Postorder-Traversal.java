/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        if(root == null) {
            return output;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        TreeNode prev = null;
        while(!st.empty()) {
            
            //first iterate down left nodes until current node is leaf, then pop from stack
            TreeNode curr = st.peek();
            if(prev == null || prev.left == curr || prev.right == curr) {
                if(curr.left != null) {
                    st.push(curr.left);
                } else if(curr.right != null) {
                       st.push(curr.right);
                } else {
                    st.pop();
                    output.add(curr.val);
                }
            
            //check if there is right child also
            //if so, push to stack
            //else pop parent node from stack
            } else if(curr.left == prev) {
                if(curr.right != null) {
                    st.push(curr.right);
                } else {
                    st.pop();
                    output.add(curr.val);
                }
            } else if(curr.right == prev) {
                st.pop();
                output.add(curr.val);
            }
            prev = curr;
        }
        return output;
    }
}