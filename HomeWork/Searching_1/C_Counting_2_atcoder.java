package HomeWork.Searching_1;

// T.C -> O(N*LogN) + O(Q*LogN)


import java.util.*;
import java.io.*;
import java.math.*;

public class C_Counting_2_atcoder{
	public static int solve(int[] a, int x){
		int l = 0;
		int h = a.length - 1;
		while(l<=h){
			int m = l + (h-l)/2;
			if(a[m] >= x){
				h = m - 1;
			} else{
				l = m + 1;
			}
		}

		return a.length - h - 1;

	}
	public static void main(String[] args){
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] a = new int[n];

		for(int i=0; i<n; i++){
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);

		for(int i=0; i<q; i++){
			int x = sc.nextInt();
			int ans = solve(a, x);
			System.out.println(ans);
		}

	}
}