class Solution {
    // public int minDistance(String word1, String word2, int i, int j, int[][] dp){
    //     if(i==word1.length() && j==word2.length()) { return 0; }
    //     if(i == word1.length()) { return word2.length()-j; }
    //     if(j == word2.length()) { return word1.length()-i; }

    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(word1.charAt(i)==word2.charAt(j)){
    //         return minDistance(word1, word2, i+1, j+1, dp);
    //     } 
        
    //     int addOp = minDistance(word1, word2, i, j+1, dp);
    //     int removeOp = minDistance(word1, word2, i+1, j, dp);
    //     int updateOp = minDistance(word1, word2, i+1, j+1, dp);

    //     return dp[i][j] = Math.min(addOp, Math.min(removeOp, updateOp))+1;
    // }
    // public int minDistance(String st1, String st2) {
    //     int n = st1.length();
	// 	int m = st2.length();
	// 	int[][] dp = new int[n+1][m+1];
	// 	for(int i = 0; i<=n; i++){
	// 		dp[i][0] = i;
	// 	}
	// 	for(int i = 0; i<=m; i++){
	// 		dp[0][i] = i;
	// 	}

	// 	for(int i=1; i<=n; i++){
	// 		for(int j=1; j<=m; j++){
	// 			if(st1.charAt(i-1)==st2.charAt(j-1)){
	// 				dp[i][j] = dp[i-1][j-1];
	// 			}
	// 			else{
    //                 int addop = dp[i][j-1];
    //                 int remop = dp[i-1][j];
    //                 int updop = dp[i-1][j-1];
	// 				dp[i][j] = Math.min(addop, Math.min(remop, updop)) + 1;
	// 			}
	// 		}
	// 	}

	// 	return dp[n][m];
    // }
    public int minDistance(String st1, String st2) {
        int n = st1.length();
		int m = st2.length();
		int[] dp = new int[m+1];
		
		for(int i = 0; i<=m; i++){
			dp[i] = i;
		}

		for(int i=1; i<=n; i++){
            int[] curr = new int[m+1];
            curr[0] = i;
			for(int j=1; j<=m; j++){
				if(st1.charAt(i-1)==st2.charAt(j-1)){
					curr[j] = dp[j-1];
				}
				else{
                    int addop = curr[j-1];
                    int remop = dp[j];
                    int updop = dp[j-1];
					curr[j] = Math.min(addop, Math.min(remop, updop)) + 1;
				}
			}
            dp = curr;
		}

		return dp[m];
    }
}