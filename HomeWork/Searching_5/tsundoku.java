package HomeWork.Searching_5;

import java.util.Scanner;


// Greedy won't work here 
// For example A = [120, 5, 5, 5] B=[80, 80, 80, 80],  k = 140

// take zero book from A and then find number of books you can take from B (Using BS)
// tale 1 book from B then find number of books you can take from B (Using BS)

// You'll need prefix sum array of both A and B because if yoou are taking two books from A 
// then you will need sum of costs of first two books as books can only be taken out from top so calculate sum efficiently
// use prefix sum array for both A and B

// T.C = o(N*log(M))
public class tsundoku{

    public static int countBooks(long[] preb, long k){
        int low = 0;
        int high = preb.length-1;
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(preb[mid] <= k){
                ans = mid;
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextInt();
        long[] prea = new long[n+1];
        prea[0] = 0;
        long[] preb = new long[m+1];
        preb[0] = 0;

        for(int i=1; i<=n; i++){
            prea[i] = prea[i-1] + sc.nextInt();
        }

        for(int i=1; i<=m; i++){
            preb[i] = preb[i-1] + sc.nextInt();
        }

        int max_book = 0;

        for(int i=0; i<=n; i++){
            long remainin_cost = k - prea[i];
            if(remainin_cost<0){
                break;
            }
            int booksFromB = countBooks(preb, remainin_cost);
            max_book = Math.max(i+booksFromB, max_book);
        }

        System.out.println(max_book);

        sc.close();
    }
}
