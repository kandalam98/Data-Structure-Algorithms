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
// leet code - https://leetcode.com/problems/all-possible-full-binary-trees
class Solution {

    Map<Integer,List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(!map.containsKey(n)){
            List<TreeNode> res = new ArrayList<>();
            if(n == 1 ){
                res.add(new TreeNode(0,null,null));
            }else {
                for(int i=1 ;i<n ;i++)
                {
                    List<TreeNode> leftTree = allPossibleFBT(i);
                    List<TreeNode> rightTree = allPossibleFBT(n-i-1);
                    for(TreeNode left : leftTree){
                        for(TreeNode right : rightTree){
                            res.add(new TreeNode(0,left , right));
                        }
                    }

                }
            }
            map.put(n,res);
        }


        return map.get(n);
    }
    public void helper(int n , int start , int end){


    }
}