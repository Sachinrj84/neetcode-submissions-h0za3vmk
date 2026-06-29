class Solution {
    int[] par;
    int[] rank;
    public int countComponents(int n, int[][] edges) {
        par= new int[n];
        rank= new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=1;
        }
        int res=n;
        for(int[] edg:edges){
            res-=union(edg[0],edg[1]);
        }
        return res;
    }
    public int find(int node){
        int cur=node;
        while(cur!=par[cur]){
            par[cur]=par[par[cur]];
            cur=par[cur];
        }
        return cur;
    }
    public int union(int edg1, int edg2){
        int n1=find(edg1);
        int n2=find(edg2);
        if(n1==n2){
            return 0;
        }
        if(rank[n2]>rank[n1]){
            par[n1]=n2;
            rank[n2]+=rank[n1];
        }else{
            par[n2]=n1;
            rank[n2]+=rank[n1];
        }
        return 1;
    }
}
