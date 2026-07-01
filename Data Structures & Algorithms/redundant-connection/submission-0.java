class Solution {
    int[] par;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        par= new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<par.length;i++){
            par[i]=i;
            rank[i]=1;
        }
        for(int[] edg:edges ){
            if(!union(edg[0],edg[1])){
                return new int[]{edg[0], edg[1]};
            }
        }
        return new int[0];
    }
    public int find(int node){
        int cur=par[node];
        while(cur!=par[cur]){
            par[cur]=par[par[cur]];
            cur=par[cur];
        }
        return cur;
    }
    public boolean union(int u, int v){
        int n1=find(u);
        int n2=find(v);
        if(n1==n2) return false;
        if(rank[n1]>rank[n2]){
            par[n2]=n1;
            rank[n1]+=rank[n2];
        }else{
            par[n1]=n2;
            rank[n2]+=rank[n1];
        }
        return true;
    }
}
