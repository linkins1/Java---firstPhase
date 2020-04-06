package core.java.one.staticInnnerClass;

/**
 * The type Static inner class.
 * 在包外可见
 *
 */
public class StaticInnerClass {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++)
            d[i] = 100 * Math.random();
        ArrayAlg.Pair p = ArrayAlg.minmax(d);

        //该内部类Pair必须为static，否则不能在main方法中构造
        //如果去掉static就需要一个外部类对象的引用来辅助创建内部类对象
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

/**
 * The type Array alg.
 * 包外不可见，只在包内可见
 */
class ArrayAlg {
    /**
     * The type Pair.
     * Pair类型仅用于存储两个变量
     */
    public static class Pair {
        private double first;
        private double second;

        /**
         * Instantiates a new Pair.
         *
         * @param f the f
         * @param s the s
         */
        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        /**
         * Gets first.
         *
         * @return the first
         */
        public double getFirst() {
            return first;
        }

        /**
         * Gets second.
         *
         * @return the second
         */
        public double getSecond() {
            return second;
        }
    }

    /**
     * Minmax pair.
     *
     * @param values the values
     * @return the Pair  返回一个Pair类型的对象
     */
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (v > max)
                max = v;
            if (v < min)
                min = v;
        }
        return new Pair(min, max);
    }
}