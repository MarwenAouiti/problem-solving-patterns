import java.util.*;

public class Main {
    public static List<Integer> predictDays(List<Integer> day, int k) {
        // Write your code here
        List<Integer> idealDays = new ArrayList<>();
        int i = k;
        while (i < day.size() - k) {
            int before = day.get(i - 1) - day.get(i - 2);
            int after = day.get(i + 1) - day.get(i + 2);
            if (before < 0 && after < 0) {
                idealDays.add(i+1);
            }
            i++;
        }

        return idealDays;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(2);
        nums.add(2);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        //{{1,2}, {3,4}, {1,-1}};
        System.out.println(Main.predictDays(nums, 2));
    }
}