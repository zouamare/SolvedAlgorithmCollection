import java.math.BigInteger;

class Solution {
    public int solution(int n) {
        return fibonacci(n).remainder(new BigInteger("1234567")).intValue();
    }

    public BigInteger fibonacci(int n){
        BigInteger left = new BigInteger("0");
        BigInteger right = new BigInteger("1");
        for(int i =1; i<n; i++){
            BigInteger sum = left.add(right);
            left = right;
            right = sum;
        }
        return right;
    }
}