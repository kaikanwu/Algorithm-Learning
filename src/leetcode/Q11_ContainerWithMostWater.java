package leetcode;

/**
 *  Q:  给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 *      在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 *      找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *      说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *      示例:
 *      输入: [1,8,6,2,5,4,8,3,7]
 *      输出: 49
 *
 * @author kaikanwu
 * @date 06/12/2018
 */
public class Q11_ContainerWithMostWater {

    public int maxArea(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        // i 和 j 移动的目的，每次移动都舍弃两个木板中相对短的那个
        while (i < j) {
            int width = j - i;
            int h = Math.min(height[i], height[j]);
            int areaNow = width * h;

            maxArea = Math.max(areaNow, maxArea);

            if (height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return maxArea;

    }
}
