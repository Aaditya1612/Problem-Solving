package HomeWork.Searching_2;

// T.C. -> O(log(m)*log(n))
class Solution
{
    // Function to calculate a^b in log(b) time
    public double binaryPower(double a, int b) {
		double res = 1.0;
		while (b > 0) {
			if ((b & 1) == 1) {
				res = res * a;
			}
			a = a * a;
			b >>= 1;
		}
		
		return res;
	}
    public int NthRoot(int n, int m)
    {
        int low = 1;
        int high = m;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            int midPowN = (int) binaryPower((double)mid, n);
            if(midPowN == m){
                return mid;
            } else if(midPowN < m){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
public class n_root_of_m_gfg {
    
}
