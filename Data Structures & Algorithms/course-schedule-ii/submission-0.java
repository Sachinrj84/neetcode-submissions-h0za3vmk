class Solution {
    Map<Integer,List<Integer>> preMap;
    Set<Integer> visit;
    Set<Integer> cycle;
    List<Integer> res;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        preMap= new HashMap<>();
        visit= new HashSet<>();
        cycle=new HashSet<>();
        res= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            preMap.put(i,new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }
        for(int i=0;i<numCourses;i++){
            if(!dfs(i)){
                return new int[0];
            }
        }
        int[] output= new int[numCourses];
        for(int i=0;i<numCourses;i++){
            output[i]=res.get(i);
        }
        return output;
    }
    public boolean dfs(int crs){
        if(cycle.contains(crs)) return false;
        if(visit.contains(crs)) return true;
        cycle.add(crs);
        List<Integer> preList= preMap.get(crs);
        int size= preList.size();
        for(int i=0;i<size;i++){
            if(!dfs(preList.get(i))) return false;
        }
        cycle.remove(crs);
        visit.add(crs);
        res.add(crs);
        return true;
    }
}
