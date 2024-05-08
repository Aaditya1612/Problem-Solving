package HomeWork.Graph_7;


// T.C: O(N)
// S.C: O(2*N)

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

    public boolean canUnite(int v1, int v2){
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
    public int minSwapsCouples(int[] row) {
        if (row.length < 2) return 0;

        int swaps = 0;
        DSU dsu = new DSU(row.length/2);
        for (int i = 0; i<row.length; i = i+2){
            // for two people to be couples they should be adjascent integer and the first
            // integer in each couple set should be divisble by 2 line (0, 1) , (2, 3) ...
            // so if current set is not a valid couple then we will unite their seats

            // like 2 should be at seat 1 with 3, 3 should also be at seat 1, 
            // 5 should be at seat 2 with 4
            // so the seat of any person is given by val/2

            // we are uniting the seats because using it whenever the samecombination 
            // of disbalance is found in future then we don not count it as a new swap
            // because it will get covered in previous swap
            if (Math.abs(row[i] - row[i+1]) != 1 || Math.min(row[i], row[i+1])%2 != 0){
                if (dsu.canUnite(row[i]/2, row[i+1]/2)){
                    swaps++;
                }
            }
        }
        
        return swaps;
    }

}
public class couples_holding_hnads {
    
}
