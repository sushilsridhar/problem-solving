package hashing;

import java.util.HashMap;

/*
    Given an array of N elements, count the number of duplicate pairs

    (i,j) -> i!=j , A[i]==A[j]

    0  1  2  3  4  5  6  7  8  9
    1, 2, 1, 4, 1, 2, 3, 4, 1, 6

    0 2, 0 4, 0 8, 2 4, 2 8, 4 8 -> 6 pairs

    ans -> 8 pairs

    approach: use frequency map

    tc: O(n)
    sc: O(n)
 */
public class CountNoOfDuplicatePairs {

    public static void main(String[] args) {

                // 0  1  2  3  4  5  6  7  8  9
        int a[] = {1, 2, 1, 4, 1, 2, 3, 4, 1, 6};

        System.out.println(countDuplicatePairs(a));
    }

    private static int countDuplicatePairs(int[] a) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int i: a) {
            if(freqMap.containsKey(i)) {
                freqMap.put(i, freqMap.get(i) + 1);
            } else {
                freqMap.put(i, 1);
            }
        }

        int sum = 0;
        for(int i: a) {
            if(freqMap.containsKey(i)) {
                sum = sum + freqMap.get(i) - 1;
                freqMap.put(i, freqMap.get(i) - 1);
            }
        }

        return sum;
    }
}
