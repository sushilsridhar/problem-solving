package stack.adv;

import java.util.Stack;

/*
    Given an array,
    1) find the nearest small element on the left for every element
    2) find the nearest small element on the right for every element

     5  2  8  10  12  6   1
    -1 -1  2   8  10  2  -1 -> ans

    nearest smaller element on right

     5  2  8  10  12  6   1
     2  1  6   6   6  1  -1 -> ans

    approach: maintain a candidate list of possible candidates
    top of stack will always have the element smaller to the current element of array

    tc: O(n), we are iterating once over the array, and inserting all elements only once,
    so deletion will also run for max n times,

    n(insertion) + n(deletion) = O(n)

    sc: O(n)
 */
public class NearestSmallElement {

    public static void main(String[] args) {

        int a[] = {5, 2, 8, 10, 12, 6, 1};

        int[] ans = bruteForce(a);
        for(int i: ans) {
            System.out.print(i+" ");
        }

        System.out.println("");

        int[] ans1 = nsl(a);
        for(int j: ans1) {
            System.out.print(j+" ");
        }

        System.out.println("");
        System.out.println("nsr: ");

        int[] ans3 = nsr(a);
        for(int k: ans3) {
            System.out.print(k+" ");
        }
    }

    // tc: O(n)
    // sc: O(n)
    private static int[] nsl(int[] a) {
        int[] ans = new int[a.length];
        Stack<Integer> stack = new Stack<>();

        ans[0] = -1;
        stack.push(a[0]);

        for(int i=1; i<a.length; i++) {

            while(!stack.empty() && a[i] <= stack.peek()) {
                stack.pop();
            }

            if(stack.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(a[i]);
        }

        return ans;
    }

    // tc: O(n)
    // sc: O(n)
    private static int[] nsr(int[] a) {
        int[] ans = new int[a.length];
        Stack<Integer> stack = new Stack<>();

        ans[a.length-1] = -1;
        stack.push(a[a.length-1]);

        for(int i=a.length-2; i>=0; i--) {

            while(!stack.empty() && a[i] <= stack.peek()) {
                stack.pop();
            }

            if(stack.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(a[i]);
        }

        return ans;
    }

    // tc: O(n^2)
    private static int[] bruteForce(int[] a) {
        int[] ans = new int[a.length];

        for(int i=0; i<a.length; i++) {
            int answer = -1;
            for(int j=0; j<i; j++) {
                if(a[j] < a[i]) {
                    answer = a[j];
                }
            }
            ans[i] = answer;
        }

        return ans;
    }
}
