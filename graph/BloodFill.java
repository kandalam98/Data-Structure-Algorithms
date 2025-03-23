//https://leetcode.com/problems/flood-fill/
//TC - O(n2) or O(m * n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)return image;
        dfs(image , sr , sc , color , image[sr][sc]);
        return image;
    }
    public void dfs(int[][] ans, int sr, int sc, int color , int curr) {
        if(sr < 0 || sr >= ans.length || sc < 0 || sc >= ans[0].length ){
            return;
        }

        if(curr != ans[sr][sc]){
            return;
        }
        ans[sr][sc] = color;

        dfs(ans , sr + 1 , sc , color , curr);
        dfs(ans , sr - 1 , sc , color, curr);
        dfs(ans , sr  , sc+1, color,curr);
        dfs(ans , sr  , sc-1 , color,curr);
    }
}