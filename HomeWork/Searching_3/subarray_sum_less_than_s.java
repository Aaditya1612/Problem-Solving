package HomeWork.Searching_3;
import java.util.*;

public class subarray_sum_less_than_s {
    public static boolean isValid(int[] arr, int n, int s, int mid){
        int size = 0;
        int sum = 0;

        for(int i=0; i<n; i++){
            sum += arr[i];
            if(sum > s){
                if(size != mid){ return false;}
                sum = arr[i];
                size = 0;
            }
            size++;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        int low = 1;
        int high = n;
        int ans = 1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(isValid(arr, n, s, mid)){
                low = mid + 1;
                ans = mid;
            } else{
                high = mid - 1;
            }
        }

        System.out.println(ans);
        sc.close();
    }
}
