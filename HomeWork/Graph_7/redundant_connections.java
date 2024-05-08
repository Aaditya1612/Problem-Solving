package HomeWork.Graph_7;

class DSU{
    int[] parent;
    int[] size;

    public DSU(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for(int i=1; i<=n; i++){
            parent[i] = i;
            size[i] = 0;
        }
    }

    public int findUparent(int node){
        if(parent[node] == node){
            return node;
        }

        return parent[node] = findUparent(parent[node]);
    }

    public boolean canUnit(int v1, int v2){
        int up_v1 = findUparent(v1);
        int up_v2 = findUparent(v2);

        if(up_v1 == up_v2){
            return false;
        }

        if(size[up_v1] <= size[up_v2]){
            parent[up_v1] = up_v2;
            size[up_v2] += size[up_v1];
        } else{
            parent[up_v2] = up_v1;
            size[up_v1] += size[up_v2];
        }

        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // one redundant edge so number of nodes in this question  = number of edges
        DSU dsu = new DSU(edges.length);

        for(int[] edge: edges){
            if(!dsu.canUnit(edge[0], edge[1])){
                return edge;
            }
        }

        return new int[]{-1, -1};
    }
}

public class redundant_connections {
    
}
