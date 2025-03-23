
//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

//TC - O(m) - > m  = no of edges

class Solution {
    int ans = 0;
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> forward = new ArrayList<>();
        List<List<Integer>> backward = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i=0 ; i<n ;i++){
            forward.add(new ArrayList<>());
            backward.add(new ArrayList<>());
        }
        for(int[] con : connections){
            forward.get(con[0]).add(con[1]);
            backward.get(con[1]).add(con[0]);
        }
        helper(0 , forward , backward , visited);
        return ans;
    }
    public void helper(int source , List<List<Integer>> forward  , List<List<Integer>> backward , boolean[] visited ){
        visited[source] = true;
        for(int temp : forward.get(source)){
            if( !visited[temp]){
                ans++;
                helper(temp , forward , backward , visited);
            }
        }
        for(int temp : backward.get(source)){
            if( !visited[temp]){
                helper(temp , forward , backward , visited);
            }
        }

    }
}