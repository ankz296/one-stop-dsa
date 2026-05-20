package DSA.stack.nearestElement;

import java.util.Arrays;

public class TrappingRainWater {

    /**
     * https://leetcode.com/problems/trapping-rain-water/description/
     * https://algomaster.io/practice/dsa/trapping-rain-water?list=am-300
     * Here we choose claude AI's response.
     */
    public static int trap(int[] height) {
        int leftMax = 0, rightMax = 0, water = 0;

        int left = 0, right = height.length - 1;

        while (left < right) {
            // leftMax aur rightMax update karo
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                // left is bottleneck -> we have to find max from left side
                water += leftMax - height[left];
                left++;
            } else {
                // right side is bootleneck -> we have to find max from right side
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

    static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

}
