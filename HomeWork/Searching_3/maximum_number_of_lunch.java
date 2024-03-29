
import java.util.*;

// T.C -> O(log(max(freq))*O(unique_food_items) + O(n), n -> length of B
// S.C -> O(n)
public class Main
{

    // function to check if it is possible to prepare mid number of lunches with every lunch having at least A itmes.
    public static boolean ableToPrepareLunch(int[] b, int n, HashMap<Integer, Integer> map, int a, int mid){
	        int items = 0;
	        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
	            if(entry.getValue() >= mid){
	                items+=entry.getValue()/mid; // a lunch box can contain multiple items of same ID/
	            }
	        }
	        
	        return items>=a;
    	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int n = sc.nextInt();
		int[] b = new int[n];
		
		for(int i=0; i<n; i++){
		    b[i] = sc.nextInt();
		}
		
		HashMap<Integer, Integer> map = new HashMap<>(); // to keep track of number of items of particular ID in list B.
	        int low = 1;
	        int high = -1;  // high can be maximum frequency
	        for(int i: b){
	            map.put(i, map.getOrDefault(i, 0)+1);
	            high = Math.max(high, map.get(i));
	        }
        
		int ans = 0;
		while(low<=high){
		    int mid = low + (high - low)/2;
		    if(ableToPrepareLunch(b, n, map, a, mid)){ // if it is possible then store answer and move to right to maximize answer
		        low = mid + 1;
		        ans = mid;
		    } else{ // else move to left
		        high = mid - 1;
		    }
		}
		
		System.out.println(ans);
        sc.close();
	}
}
