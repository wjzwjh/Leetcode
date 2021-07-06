class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] inDegree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();

        int index = 0;
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0){
                queue.offer(i);
                result[index++] = i;
            }
        }
        
        while(!queue.isEmpty()) {
            int course = queue.poll();
             for(int i = 0; i < edges[course].size(); i++) {
                 int c = (int)edges[course].get(i);
                inDegree[c]--;
                if(inDegree[c] == 0){
                    queue.offer(c);
                    result[index++] = c;
                }
            }
        }
        
        return (index == numCourses)? result: new int[0];
    }
}
