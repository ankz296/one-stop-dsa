package DSA.array.twoPointer;

public class ContainerWithMostWater {

    /**
     * https://leetcode.com/problems/container-with-most-water
     * https://algomaster.io/practice/dsa/container-with-most-water?list=am-300
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxarea = 0;
        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;
            maxarea = Math.max(area, maxarea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }

    static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
