package leetcode;

import java.util.Arrays;

/**
 *  Q:  假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
 *      但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，
 *      这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
 *      如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 *      你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 *  A:  使用贪心思想
 *      也就是每次操作都是局部最优解，并且最后得到的结果是全局最优的。
 *
 *      这道题目中，就是先满足最小的孩子。
 *      所以先对两个数组排序。
 *
 * @author kaikanwu
 * @date 03/12/2018
 */
public class Q455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0;
        int si = 0;
        // 任何一个超过数组长度，都退出循环
        while (gi < g.length && si < s.length) {

            // 也就是第 si 个饼干可以满足第 gi 个孩子时， gi++ 换到下一个孩子。
            if (g[gi] <= s[si]) {
                gi++;
            }
            // 不管满不满足第 gi 个孩子，饼干都要换到下一个。
            si++;

        }
        // 由于退出条件的设定，返回的 gi 就是我们要求输出的人数
        return gi;
    }
}
