package test;
import java.util.*;
import java.io.*;
/**
 * Q:
 *
 *
 * @author kaikanwu
 * @date 29/10/2018
 */
public class Main {

    /**
     * PonyAI的自动驾驶车辆中有一个神奇的装置包含了N个齿轮，这N个齿轮依次标号为0至N-1。
     * 现在这些齿轮被连成了一个环，第i个齿轮分别和第(i-1)和齿轮以及第(i+1)个齿轮相连，第0个齿轮和第N-1个齿轮相连。
     * 当整个装置运作起来的时候，如果两个齿轮啮合（相邻），那么它们必定朝相反的方向旋转，一个顺时针一个逆时针旋转。
     *
     * 这N个齿轮每个都有一个理想的旋转方向，这些信息被一个长度为N的字符串D表示。
     *
     * 如果D[i]='L'表示第i个齿轮理想的旋转方向为朝左旋转（逆时针），如果D[i]='R'表示第i个齿轮理想的旋转方向为朝右旋转（顺时针），
     * 显然，我们的装置不能满足所有齿轮的理想旋转方向。
     * 现在我们允许移除这个齿轮环上的一些齿轮，使得剩下的齿轮能够同时向其理想的方向旋转。
     * 你需要计算出最小需要移除的齿轮数量。
     *
     * 注意，当移除了一个齿轮之后，会在和它啮合的两个齿轮间创造一个间隙，例如移除了齿轮7之后，齿轮6和齿轮8不再啮合，转动方向不再受彼此约束。
     */






    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String d = br.readLine();


        if (d.length()< 2){
            System.out.println("0");
        }

        int count = 0;

        for (int i = 0; i < d.length() ; i++) {

            char index = d.charAt(i);
            if ( (i+1)< d.length() && index == d.charAt(i+1)){
                count++;
                i++;
            }

        }

        if (d.charAt(0) == d.charAt(d.length()-1) && d.charAt(d.length()-1) != d.charAt(d.length()-2)){
            count++;
        }

        System.out.println(count);
    }
}
