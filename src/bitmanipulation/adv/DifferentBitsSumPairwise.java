package bitmanipulation.adv;

/*
    We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
    For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

    You are given an array of N positive integers, A1, A2 ,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 10^9+7.

     A = [1, 3, 5]

     f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5)
     = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8

 */
public class DifferentBitsSumPairwise {

    public static void main(String[] args) {

        int A[] = {1, 3, 5};  // ans 8
        System.out.println(bruteForce(A));
    }

    private static int bruteForce(int[] A) {
        int sum = 0;
        int mod = (int) Math.pow(10,9) + 7;
        for(int i=0; i<A.length; i++) {
            int noOfSetBits = 0;
            for(int j=i+1; j<A.length; j++) {
                int ele1 = A[i];
                int ele2 = A[j];

                int xor = ele1 ^ ele2;

                for(int k=0; k<32; k++) {
                    if((xor & (1<<k)) != 0) {
                        noOfSetBits++;
                    }
                }
            }
            sum = ((sum%mod) + ((noOfSetBits*2)%mod))%mod;
        }

        return sum;
    }
}
