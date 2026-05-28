class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res= new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), candidates, target);
        return res;
    }

    public void dfs(int i, List<Integer> curr, int[] candidates, int target){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return ;
        }
        if(i>= candidates.length || 0>target){
            return;
        }
        curr.add(candidates[i]);
        dfs(i+1,curr, candidates, target-candidates[i]);
        curr.remove(curr.size()-1);
        
        while(i+1 < candidates.length && candidates[i]==candidates[i+1] ){
            i++;
        }
        dfs(i+1, curr, candidates, target);
    }
}
