package HomeWork.Searching_5;

import java.util.Scanner;

// To effieciently count number of terms divisible by a or b or c from 1 to mid we can use veinn diagram
// n(A+B+C) = n(A) + n(b) + n(c) - n(A intersect B) - n(B intersect C) - n(C intersect A) + n(A Uninon B Union C)

class Solution{
    public int findLCM(int a, int b) 
    { 
        int greater = Math.max(a, b); 
        int smallest = Math.min(a, b); 
        for (int i = greater;; i += greater) { 
            if (i % smallest == 0) 
                return i; 
        } 
    } 
    public int countTerms(int a, int b, int c, int mid){
        int ans = mid/a + mid/b + mid/c - mid/findLCM(a, b) - mid/findLCM(b, c) - mid/findLCM(c, a) + mid/findLCM(a, findLCM(b, c));
        return ans;
    }
    public int findNthTerm(int a, int b, int c, int n){
        int low = 1;
        int high = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high-low)/2;
            int cnt = countTerms(a, b, c, mid);
            if(cnt == n) { return mid;}
            else if(cnt < n) { low = mid + 1;}
            else { high = mid - 1;}
        }

        return -1;
    }
}

public class nth_term_divisible_by_a_b_c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();
        Solution obj = new Solution();
        System.out.println("Nth term is: "+obj.findNthTerm(a, b, c, n));

        sc.close();
    }
}
