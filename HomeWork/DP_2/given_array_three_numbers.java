package HomeWork.DP_2;

import java.util.*;




public class given_array_three_numbers {

    // Recursion + Memoization
    // T.C: O(N)
    // S.C: O(N) + O(N)

    public static int maximize(int[] arr, int i, boolean[] used, int x, int y, int z, int[] cache){

        if(i == arr.length){
            return -(int)1e9;
        }
        
        if(cache[i] != -1){
            return cache[i];
        }

        int maxX = 0;
        int maxY = 0;
        int maxZ = 0;
        if(!used[0]){
            used[0] = true;
            maxX = arr[i]*x + maximize(arr, i, used, x, y, z, cache);
            used[0] = false;
        }
        else if(!used[1]){
            used[1] = true;
            maxY = arr[i]*y + maximize(arr, i, used, x, y, z, cache);
            used[1] = false;
        }
        else if(!used[2]){
            used[2] = true;
            maxZ = arr[i]*z + maximize(arr, i, used, x, y, z, cache);
            used[2] = false;
        }

        int excludeCurr = maximize(arr, i+1, used, x, y, z, cache);

        return Math.max(maxX, Math.max(maxY, Math.max(maxZ, excludeCurr)));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        sc.close();

        boolean[] used = new boolean[3]; // 0 -> x, 1 -> y, 2 -> z

        int[] cache = new int[n];
        Arrays.fill(cache, -1); 

        System.out.println(maximize(arr, 0, used, x, y, z, cache));

    }
}
