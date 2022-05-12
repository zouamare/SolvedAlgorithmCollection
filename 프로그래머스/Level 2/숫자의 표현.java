class Solution {
    public int solution(int n) {
        int cnt = 0;

        int left = 1;
        int right = 2;

        while(left<=n){
            int total = 0;
            for(int k=left; k<=right; k++)
                total += k;
            if(total<n)
                right++;
            else if(total==n){
                cnt++;
                left++;
            }
            else
                left++;
        }
        return cnt;
    }
}