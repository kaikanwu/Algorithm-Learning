package pointToOffer;

/**
 * Q： 设计一个类，我们只能生成该类的一个实例
 * A： 也就是实现一个单例（singleton）模式
 *
 *  单例模式的定义：指实现了特殊模式的类，该类仅能被实例化一次，产生一个唯一的对象
 *  应用举例：windows 的任务管理器， 该类仅能被实例化一次，产生唯一的一个对象。
 *  分类：饿汉式、懒汉式、双检锁、静态内部类和枚举。
 *  评价指标： 单例（必须），线程安全，延迟加载，防止反序列化产生新对象，防止反射攻击。
 *
 *  实现方法的选择：一般情况下直接选择饿汉式就可以。要求延迟加载时倾向于选择静态内部类，
 *               涉及到反序列化创建对象或反射问题最好选择枚举。
 *
 *
 */
public class P32_Singleton {
    /**
     *  一、饿汉式
     *  特点：线程安全。
     *  缺点：在类初始化执行到静态属性时就分配了资源，有资源浪费的问题。
     */
     public static class Singleton1{
        /**
         * 注意 static final这两个修饰符的顺序
         * 在程序被编译成字节码后，这两个值的顺序并没有影响，但是更推荐static final 修饰
         */
        private  static final  Singleton1 INSTANCE = new Singleton1();

        private Singleton1() {

        }

        public static Singleton1 getInstance() {
            return INSTANCE;
        }
    }


    /**
     *  二、懒汉式（非线程安全）
     *  特点：在第一次调用获取实例方法时分配内存，实现了懒加载。
     *  缺点：非线程安全
     */
    public static class Singleton2{
        private static Singleton2 instance = null;

        private Singleton2() {

        }

        public static Singleton2 getInstance() {
            if (instance == null){
                instance = new Singleton2();
            }
            return instance;
        }
    }


    /**
     *  三、懒汉式变种，使用synchronized 同步方法，支持多线程
     *
     *  特点：线程安全。
     *  缺点：synchronized 而造成的阻塞致使效率低，而且很多阻塞是没有必要的
     */
    public static class Singleton3{
        private static Singleton3 instance = null;

        private Singleton3() {

        }

        public static synchronized Singleton3 getInstance() {
            if (instance == null) {
                instance = new Singleton3();
            }
            return instance;
        }
    }


    /**
     * 四、懒汉式变种，使用synchronized 同步块，支持多线程
     * 特点：写法不同，但是和版本三有一样的问题
     */
    public static class Singleton4{
        private static Singleton4 instance = null;

        private Singleton4() {

        }

        public static Singleton4 getInstance() {
            synchronized (Singleton4.class){
                if (instance == null){
                    instance = new Singleton4();
                }

            }
            return instance;
        }
    }


    /**
     *  五、双检锁 DCL， 支持多线程-懒汉式
     *  （静态内部类，使用双重校验锁，线程安全【推荐】）
     *  特点：线程安全，多进行一次if 判断，加入volatile 修饰
     *  优点是：只有在第一次实例化的时候加锁，之后不会加锁。
     *  如果不加入volatile, 可能出现第一个if 判断不为null， 但还并未执行构造函数的情况下，
     *  因为java 编译器会进行指令重排；
     *
     */
    public static class Singleton5{
        private volatile static Singleton5 instance = null;

        private Singleton5() {

        }

        public static Singleton5 getInstance() {
            if (instance == null){
                synchronized (Singleton5.class){
                    if (instance == null){
                        instance = new Singleton5();
                    }
                }
            }

            return instance;
        }

    }

    /**
     * 六、静态内部类，支持多线程-懒汉式
     */
    public static class Singleton6{

        private static class Singleton6Holder{
            private static final Singleton6 INSTANCE = new Singleton6();
        }


        private Singleton6() {

        }

        public static Singleton6 getInstance() {
            return Singleton6Holder.INSTANCE;
        }
    }



    public enum Singleton7{
        INSTANCE;

        public void whateverMethod() {

        }
    }








    public static void main(String[] args){
        System.out.println(Singleton1.getInstance() == Singleton1.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
        System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
        System.out.println(Singleton5.getInstance() == Singleton5.getInstance());
        System.out.println(Singleton6.getInstance() == Singleton6.getInstance());
        System.out.println(Singleton7.INSTANCE == Singleton7.INSTANCE);



    }



}
