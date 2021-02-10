package practice.dynamic;

//#56
//..https://www.youtube.com/watch?v=jkygQmOiCCI&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=45
class EggProblem {

    public static int[][] t;

    public static void main(String[] args) {
        int n = 3;
        int k = 5;

        t = new int[n + 1][k + 1];
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= k ; j++) {
                t[i][j] = -1;
            }
        }

        System.out.println(eggDrop(n, k));
        // System.out.println(eggDropDp(n, k));
        System.out.println(eggDropDpO(n, k));
    }

    //basic recursion: worst runtime
    static int eggDrop(int n, int k) {
        // Your code here
        if(k == 1 || k == 0) {
            return k;
        }

        if(n == 1) {
            return k;
        }

        int min = Integer.MAX_VALUE;

        for (int f = 1; f <= k; f++) {
            int worst_case = 1 + Math.max(eggDrop(n - 1, f - 1), eggDrop(n, k - f));
            min = Math.min(worst_case, min);
        }


        return min;
    }

    //only three lines added
    static int eggDropDp(int n, int k) {
        // Your code here
        if(k == 1 || k == 0) {
            return k;
        }

        if(n == 1) {
            return k;
        }

        if(t[n][k] != -1) {
            return t[n][k];
        }

        int min = Integer.MAX_VALUE;

        for (int f = 1; f <= k; f++) {
            int worst_case = 1 + Math.max(eggDrop(n - 1, f - 1), eggDrop(n, k - f));
            min = Math.min(worst_case, min);
        }

        t[n][k] = min;
        return t[n][k] ;
    }

    //only three lines added
    static int eggDropDpO(int n, int k) {
        // Your code here
        if(k == 1 || k == 0) {
            return k;
        }

        if(n == 1) {
            return k;
        }

        if(t[n][k] != -1) {
            return t[n][k];
        }


        int min = Integer.MAX_VALUE;
        for (int f = 1; f <= k; f++) {
            int low;
            int high;

            if(t[n - 1][k - 1] != -1) {
                low = t[n - 1][k - 1];
            } else {
                low = eggDrop(n - 1, f - 1);
            }

            if(t[n][k - f] != -1) {
                high = t[n][k - f];
            } else {
                high = eggDrop(n, k - f);
            }

            int worst_case = 1 + Math.max(low, high);
            min = Math.min(worst_case, min);
        }

        t[n][k] = min;
        return t[n][k] ;
    }


}