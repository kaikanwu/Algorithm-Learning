package huawei;

import java.util.*;

/**
 * 思路:
 * 首先必须注意当ip属于某类地址同时属于私有地址都需要进行加1
 * 1)先判断子网掩码是否合法,如果不合法则直接error+=1
 * 思路:说下,我的判断子网掩码的方法与上述不同,既然子网掩码为前面的连续的1,后面为连续的0,
 * 我们可以计算前面2个01串不同的次数,如果为2则说明是正确的,如果超过2,说明不对。这里也正好
 * 不需要判断子网255.255.255.255和0.0.0.0等特殊的子网掩码,在我的方法里这2种特殊子网掩码是不合法的。
 * 2)判断属于哪类地址
 * 3)判断是否是私有地址
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW15 {

    public static void main(String[]args){
        int typeA=0;
        int typeB=0;
        int typeC=0;
        int typeD=0;
        int typeE=0;
        int error=0;
        int privateIp=0;
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            String information=s.next();
            String [] info=information.split("~");
            if(info==null||info.length!=2)
                break;
            String ip=info[0];
            String mask=info[1];
            String []ips=ip.split("\\.");
            if(ips==null||ips.length<4)
            {
                error+=1;
                //  System.out.println("out..");
                continue;
            }
            int v=Integer.parseInt(ips[0]);

            int two=Integer.parseInt(ips[1]);
            //process mask
            boolean isMask=checkMask(mask);
            if(!isMask){
                error+=1;
                continue;//不进行下面处理
            }
            //处理ip地址
            if(v>=1&&v<=126)
                typeA++;
            else if(v>=128&&v<=191)
                typeB+=1;
            else if(v>=192&&v<=223)
                typeC+=1;
            else if(v>=224&&v<=239)
                typeD+=1;
            else if(v>=240&&v<=255)
                typeE+=1;
            if(v==10||(v==172&&two>=16&&two<=31)||(v==192&&two==168))
                privateIp+=1;
        } //end while
        System.out.println(typeA+" "+typeB+" "+typeC+" "+typeD+" "+typeE+" "+error+" "+privateIp);
    }
    public static boolean checkMask(String mask) {
        String[] masks = mask.split("\\.");
        int v = -1;
        int changeTime = 0;//计算相邻数不同的次数
        for (int i = masks.length - 1; i >= 0; i--) {
            int times = 0;
            int value = Integer.parseInt(masks[i]);
            while (times < 8) {
                if ((value & 1) != v) {
                    changeTime += 1;
                    v = value & 1;
                }
                if (changeTime >= 3){
                    return false;
                }

                value >>= 1;
                times++;
            } //end while
        } //end for
        return changeTime == 2 ? true : false;
    }

}
