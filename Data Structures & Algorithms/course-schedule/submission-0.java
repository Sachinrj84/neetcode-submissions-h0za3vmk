class Solution {
    Set<Integer> visitSet;
    Map<Integer,List<Integer>> preMap;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visitSet= new HashSet<>();
        preMap= new HashMap<>();
        for(int i=0;i<numCourses;i++){
            preMap.put(i, new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }
        for(int[] pre: prerequisites){
            if(!dfs(pre[0])){
                return false;
            }
        }
        return true;

    }
    public boolean dfs(int crs){
        if(visitSet.contains(crs)){
            return false;
        }
        if(preMap.get(crs).size()==0){
            return true;
        }
        visitSet.add(crs);
        List<Integer> crsList=preMap.get(crs);
        int n=crsList.size();
        for(int i=0;i<n;i++){
            if(!dfs(crsList.get(i))){
                return false;
            }
        }
        visitSet.remove(crs);
        preMap.put(crs,new ArrayList<>());
        return true;
    }
}
