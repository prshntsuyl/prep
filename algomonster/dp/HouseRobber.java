import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//the only constraint stopping you from robbing every one of them is that 
//adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//determine the maximum amount of money you can rob tonight without alerting the police.
class HouseRobber {
    public static int rob(List<Integer> nums) {
        // terminating
        int size = nums.size();
        if (size == 0) {
            return 0;
        } else if (size < 2) {
            return nums.get(0);
        }

        //initialise
        int[] dp = new int[size];
        Arrays.fill(dp, 0);
        
        dp[0] = nums.get(0);
        dp[1] = Math.max(nums.get(0), nums.get(1));

        for (int i = 2; i < nums.size(); i++) {
            dp[i] = Math.max(dp[i-2] + nums.get(i),
                             dp[i-1]);
        }

        return dp[size-1];
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Collections.emptyList() : Arrays.asList(s.split(" "));
    }

    //2 7 9 3 1 -> 12
    //1 2 3 1 -> 4
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = rob(nums);
        System.out.println(res);
    }
}

