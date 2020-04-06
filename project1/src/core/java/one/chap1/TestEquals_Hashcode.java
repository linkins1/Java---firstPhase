package core.java.one.chap1;

/**
 * The type Test 2.
 * 验证了equals方法与==以及hashcode的关系
 */
public class TestEquals_Hashcode {
    private int id;
    private String name;

    /**
     * Instantiates a new Test 2.
     *
     * @param aid   the aid
     * @param aname the aname
     */
    public TestEquals_Hashcode(int aid, String aname){
        id = aid;
        name = aname;
    }
    public boolean equals(Object aObject){
        if(this == aObject)
            return true;
        if(aObject == null)
            return false;
        if(this.getClass() != aObject.getClass())
           return false;
        TestEquals_Hashcode t = (TestEquals_Hashcode) aObject;
        return (this.id == t.id)&&(name.equals(t.name));
    }

    /**
     * The entry point of application.
     *
     * @param agrs the input arguments
     */
    public static void main(String[] agrs) {
        TestEquals_Hashcode t1 = new TestEquals_Hashcode(1, "lucy");
        TestEquals_Hashcode t2 = new TestEquals_Hashcode(1, "jack");
        TestEquals_Hashcode t3 = new TestEquals_Hashcode(2, "jack");
        TestEquals_Hashcode t4 = new TestEquals_Hashcode(2, "jack");
        System.out.print("the result is :");
        if (t2.equals(t3))
            System.out.println("two objects(t2&t3) are equal");
        else
            System.out.println("two objects(t2&t3) are different");
        if (t3.equals(t4))
            System.out.println("t3 = t4");//并不是因为两者引用相同而相同，是因为两者内容相同
        int id1 = t1.id;
        int id2 = t2.id;
        System.out.println("t1's id = t2's id:"+ (id1==id2));
        String id3 = "1";
        String id4 = new String("1");
        if (id3 != id4) {
            System.out.print("id3 != id4");
        }
        int hash1 = id3.hashCode();
        int hash2 = id4.hashCode();
        if (hash1 == hash2)
            System.out.println(", though the hashcodes are the same" + ", id3's hashcode = " + hash1 + ", id4's hashcode = " + hash2);
        int id5 = t3.id;
        int id6 = t4.id;
            System.out.print("t3's id = t4's id: "+(id5 == id6));//不同的对象中的相同的值的引用相同,但是两个对象的引用并不相同
        if (t3 != t4)
            System.out.println(", though t3!=t4");
    }
}
