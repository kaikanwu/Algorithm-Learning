package test;

/**
 * @author kaikanwu
 * @date 28/11/2018
 */
class SingleTon{
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 0;

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {

        return singleTon;
    }

}

public class Test {

    public static void main(String[] args) {
//        SingleTon singleTon = SingleTon.getInstance();
//
//        System.out.println("count1 = " + SingleTon.count1);
//        System.out.println("count2 = "+ SingleTon.count2);



        int i = 3 + (4-3)/2;
        int l = (3+4)/2;
        System.out.println(i);
        System.out.println(l);
        Object obj = new Object();

    }





}
