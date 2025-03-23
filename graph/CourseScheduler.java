//https://leetcode.com/problems/course-schedule/

// TC - O(m+N)


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[numCourses];
        for(int i=0 ;i<numCourses ;i++){
            graph.add(new ArrayList<>());
            visited[i]=0;
        }
        for(int[] pre :  prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        for(int i=0 ; i<numCourses ;i++){
            if(visited[i]==0 ) {
                if(notpossible(visited , i ,graph ,prerequisites)){
                    return false;
                }
            }
        }
        return true;
    }
    //0 - not visited
    //1 - processing
    //2 - processed
    public boolean notpossible(int[] visited , int i , List<List<Integer>> graph , int[][] prerequisites) {
        if(visited[i] == 1 ){
            return true;
        }
        List<Integer> temp = graph.get(i);
        visited[i] = 1;

        for(Integer  t : temp){
            if(visited[t] != 2){
                if(notpossible(visited , t ,graph ,prerequisites)){
                    return true;
                }
            }

        }
        visited[i] = 2;
        return false;
    }
}